package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.EventsEmployees;
import com.hybrid.hybridhavenapi.Service.EventsEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events-employee")
public class EventsEmployeeController {

    @Autowired
    private EventsEmployeeService eventsEmployeesService;

    @PostMapping
    public ResponseEntity<EventsEmployees> createEventsEmployees(@RequestBody EventsEmployees eventsEmployees) {
        EventsEmployees savedEventsEmployees = eventsEmployeesService.saveEventsEmployees(eventsEmployees);
        return new ResponseEntity<>(savedEventsEmployees, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EventsEmployees> getEventsEmployeesById(@PathVariable Integer id) {
        EventsEmployees eventsEmployees = eventsEmployeesService.getEventsEmployeesById(id);
        if (eventsEmployees != null) {
            return new ResponseEntity<>(eventsEmployees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<EventsEmployees>> getAllEventsEmployees() {
        List<EventsEmployees> eventsEmployeesList = eventsEmployeesService.getAllEventsEmployees();
        return new ResponseEntity<>(eventsEmployeesList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventsEmployees(@PathVariable Integer id) {
        eventsEmployeesService.deleteEventsEmployees(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
