package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.Employee;
import com.hybrid.hybridhavenapi.Entity.NeighbourHood;
import com.hybrid.hybridhavenapi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public ResponseEntity<?> getAllEmployees(){
        try {
            Iterable<Employee> employees = employeeService.getAllEmployees();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving employees");
        }
    }

    @GetMapping("employees/id/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(employee != null){
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("employees/name/{employeeName}")
    public List<Employee> getEmployeeByName(@PathVariable String employeeName){
        return employeeService.getEmployeeByName(employeeName);
    }

    @GetMapping("employees/reportingTo/{employeeId}")
    public Employee getEmployeeReportsToByEmployeeId(@PathVariable Integer employeeId){
        return employeeService.getEmployeeReportsToByEmployeeId(employeeId);
    }

    @PostMapping("employees")
    public ResponseEntity<Employee> createNeighbourHood(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("employees")
    public  Boolean updateEmployee(@RequestBody Employee employee)
    {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("employees/id/{employeeId}")
    public  Boolean deleteEmployee(@PathVariable Integer employeeId)
    {
        return employeeService.deleteEmployee(employeeId);
    }

}
