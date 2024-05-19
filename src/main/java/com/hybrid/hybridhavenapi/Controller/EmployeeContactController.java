package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.Employee;
import com.hybrid.hybridhavenapi.Entity.EmployeeContact;
import com.hybrid.hybridhavenapi.Service.EmployeeContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeContactController {

    @Autowired
    EmployeeContactService employeeContactServiceService;

    @GetMapping("employeeContact/")
    public Iterable<EmployeeContact> getAllEmployeeContacts(){
        return employeeContactServiceService.getAllEmployeeContacts();
    }

    @PostMapping("employeeContact/")
    public ResponseEntity<EmployeeContact> createEmployeeContact(@RequestBody EmployeeContact employeeContact) {
        EmployeeContact savedEmployeeContact = employeeContactServiceService.saveEmployeeContact(employeeContact);
        return new ResponseEntity<>(savedEmployeeContact, HttpStatus.CREATED);
    }

    @GetMapping("employeeContact/byEmail")
    public ResponseEntity<Object> getEmployeeContactByEmail(@RequestParam String email) {
        EmployeeContact employeeContact = employeeContactServiceService.getEmployeeContactByEmail(email);
        if (employeeContact != null) {
            return new ResponseEntity<>(employeeContact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee contact not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("employeeContact/id/{employeeContactId}")
    public  Boolean deleteEmployee(@PathVariable Integer employeeContactId)
    {
        return employeeContactServiceService.deleteEmployeeContact(employeeContactId);
    }
}
