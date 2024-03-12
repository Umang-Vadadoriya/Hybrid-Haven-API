package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.Employee;
import com.hybrid.hybridhavenapi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String test(){
        return "Welcome To Hybrid Haven API";
    }

    @GetMapping("employees")
    public Iterable<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/id/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer employeeId){
        return employeeService.getEmployeeById(employeeId);
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
    public  Boolean addEmployee(@RequestBody Employee employee)
    {
        return employeeService.addEmployee(employee);
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
