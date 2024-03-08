package com.hybrid.hybridhavenapi.Service;

import com.hybrid.hybridhavenapi.Entity.EmployeeContact;
import com.hybrid.hybridhavenapi.Repository.EmployeeContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeContactService {
    @Autowired
    EmployeeContactRepository employeeContactRepository;

    public Iterable<EmployeeContact> getAllEmployeeContacts(){
        return employeeContactRepository.findAll();
    }
}
