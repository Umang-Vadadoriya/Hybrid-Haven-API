package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.Vacation;
import com.hybrid.hybridhavenapi.Service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vacations")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @PostMapping
    public ResponseEntity<Vacation> createVacation(@RequestBody Vacation vacation) {
        Vacation savedVacation = vacationService.saveVacation(vacation);
        return new ResponseEntity<>(savedVacation, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Vacation> getVacationById(@PathVariable Integer id) {
        Vacation vacation = vacationService.getVacationById(id);
        if (vacation != null) {
            return new ResponseEntity<>(vacation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Vacation>> getAllVacations() {
        List<Vacation> vacationList = vacationService.getAllVacations();
        return new ResponseEntity<>(vacationList, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Vacation> updateVacation(@PathVariable Integer id, @RequestBody Vacation vacation) {
        vacation.setVacationId(id);
        Vacation updatedVacation = vacationService.saveVacation(vacation);
        return new ResponseEntity<>(updatedVacation, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteVacation(@PathVariable Integer id) {
        vacationService.deleteVacation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public List<Vacation> getVacationsByDate(@PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy") Date date) {
        return vacationService.getVacationsByDate(date);
    }

}
