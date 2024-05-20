package com.hybrid.hybridhavenapi.Service;

import com.hybrid.hybridhavenapi.Entity.Employee;
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

    public EmployeeContact getEmployeeContactByEmail(String employeeEmail) {
        EmployeeContact employeeContact = employeeContactRepository.findByEmployeeEmail(employeeEmail);
        if (employeeContact != null) {
            return new EmployeeContact(
                    employeeContact.getEmployeeContactId(),
                    employeeContact.getEmployeeId(),
                    employeeContact.getEmployeeEmail(),
                    employeeContact.getEmployeeContact()
            );
        } else {
            return null;
        }
    }

    public Boolean deleteEmployeeContact(Integer employeeId) {
        try {
            employeeContactRepository.deleteById(employeeId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public EmployeeContact saveEmployeeContact(EmployeeContact employeeContact) {
        return employeeContactRepository.save(employeeContact);
    }

}
