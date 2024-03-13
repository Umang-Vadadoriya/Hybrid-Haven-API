package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.Employee;
import com.hybrid.hybridhavenapi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String test(){
        return "Welcome To Hybrid Haven API Version 2";
    }

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

    @GetMapping("secured")
    public String addAuthEmployee(Authentication authentication) {
        System.out.println("controller called");
        return employeeService.addAuthEmployee(authentication);
//        return "secured";
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
