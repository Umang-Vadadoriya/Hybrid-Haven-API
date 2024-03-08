package com.hybrid.hybridhavenapi.Repository;

import com.hybrid.hybridhavenapi.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findByEmployeeName(String employeeName);
    public Employee findByEmployeeReportsTo(Integer employeeId);
}
