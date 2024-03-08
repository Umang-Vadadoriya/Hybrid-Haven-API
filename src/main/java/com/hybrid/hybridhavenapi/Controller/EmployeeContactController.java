package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.EmployeeContact;
import com.hybrid.hybridhavenapi.Service.EmployeeContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeContactController {

    @Autowired
    EmployeeContactService employeeContactServiceService;

    @GetMapping("employeeContact/")
    public Iterable<EmployeeContact> getAllEmployeeContacts(){
        return employeeContactServiceService.getAllEmployeeContacts();
    }
}
