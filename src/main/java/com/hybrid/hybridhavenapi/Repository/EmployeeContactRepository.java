package com.hybrid.hybridhavenapi.Repository;

import com.hybrid.hybridhavenapi.Entity.Employee;
import com.hybrid.hybridhavenapi.Entity.EmployeeContact;
import com.hybrid.hybridhavenapi.Service.EmployeeContactService;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeContactRepository extends CrudRepository<EmployeeContact, Integer> {

    EmployeeContact findByEmployeeEmail(String email);

//    EmployeeContact findTopByEmployeeEmail(String email);
}
