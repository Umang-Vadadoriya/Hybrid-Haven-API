package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.DeskBooking;
import com.hybrid.hybridhavenapi.Service.DeskBookingService;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping
    public ResponseEntity<DeskBooking> createDeskBooking(@RequestBody DeskBooking deskBooking) {
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
    public ResponseEntity<Void> deleteDeskBooking(@PathVariable Integer id) {
        System.out.println("DELETE Called");
        deskBookingService.deleteDeskBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
