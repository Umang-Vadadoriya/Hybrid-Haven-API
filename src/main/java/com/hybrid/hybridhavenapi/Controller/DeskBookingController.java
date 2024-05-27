package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.DeskBooking;
import com.hybrid.hybridhavenapi.Entity.ResponseMessage;
import com.hybrid.hybridhavenapi.Service.DeskBookingService;
import com.hybrid.hybridhavenapi.Service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/desk-bookings")
public class DeskBookingController {
    @Autowired
    private DeskBookingService deskBookingService;
    @Autowired
    private VacationService vacationService;

    @PostMapping
    public ResponseEntity<?> createDeskBooking(@RequestBody DeskBooking deskBooking) {

        Date deskBookingDate = deskBooking.getDeskBookingDate();
        Integer employeeID = deskBooking.getEmployeeId();
        boolean hasBooking = deskBookingService.hasDeskBooking(employeeID,deskBookingDate);
        boolean hasVacation = vacationService.isVacationExist(employeeID,deskBookingDate);

        if (hasBooking) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseMessage("You're Already Booked On Date: " + deskBookingDate));
        }
        if(hasVacation){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseMessage("You're Already Booked For Vacation On Date: " + deskBookingDate));
        }

        DeskBooking savedDeskBooking = deskBookingService.saveDeskBooking(deskBooking);
        return new ResponseEntity<>(savedDeskBooking, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DeskBooking> getDeskBookingById(@PathVariable Integer id) {
        System.out.println("GET Called");
        DeskBooking deskBooking = deskBookingService.getDeskBookingById(id);
        if (deskBooking != null) {
            return new ResponseEntity<>(deskBooking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<DeskBooking>> getAllDeskBookings() {
        List<DeskBooking> deskBookingList = deskBookingService.getAllDeskBookings();
        return new ResponseEntity<>(deskBookingList, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteDeskBooking(@PathVariable Integer id) {

        if (!deskBookingService.hasDeskBooking(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseMessage("There is No Desk Booking With ID: " + id));

        deskBookingService.deleteDeskBooking(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseMessage(("Desk Booking Has Been Deleted With ID: " + id)));

    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<DeskBooking>> getDeskBookingByDate(@PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy") Date date) {
        List<DeskBooking> deskBookingList = deskBookingService.getDeskBookingByDate(date);
        if (deskBookingList != null) {
            return new ResponseEntity<>(deskBookingList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
