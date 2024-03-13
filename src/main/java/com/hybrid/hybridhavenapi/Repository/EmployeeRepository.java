package com.hybrid.hybridhavenapi.Repository;

import com.hybrid.hybridhavenapi.Entity.Employee;
import com.hybrid.hybridhavenapi.Entity.EmployeeContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findByEmployeeName(String employeeName);


    public Employee findTopByEmployeeName(String employeename);

    public Employee findByEmployeeReportsTo(Integer employeeId);
//    @Procedure(name = "PROC_InsertEmployee")
//    void insert_Employee(
//            @Param("EmployeeName") String EmployeeName,
//            @Param("EmployeeEmail") String EmployeeEmail
//    );

}
