package com.hybrid.hybridhavenapi.Service;

import com.hybrid.hybridhavenapi.Entity.Employee;
import com.hybrid.hybridhavenapi.Entity.EmployeeContact;
import com.hybrid.hybridhavenapi.Repository.EmployeeContactRepository;
import com.hybrid.hybridhavenapi.Repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeContactRepository employeeContactRepository;

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> getEmployeeByName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);
    }

    public Employee getEmployeeReportsToByEmployeeId(Integer employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

        return employeeRepository.findById(employee.getEmployeeReportsTo()).get();
    }

    public Boolean addEmployee(Employee employee) {
        employee = employeeRepository.save(employee);

        if (employee != null)
            return true;
        else
            return false;
    }

    public Boolean updateEmployee(Employee employee) {
        employee = employeeRepository.save(employee);

        if (employee != null)
            return true;
        else
            return false;
    }

    public Boolean deleteEmployee(Integer employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String addAuthEmployee(Authentication authentication)
    {

        log.info("service called");
        Object principal = authentication.getPrincipal();
        if (principal instanceof DefaultOidcUser) {
            DefaultOidcUser oidcUser = (DefaultOidcUser) principal;
            String username = oidcUser.getName();
            String email = oidcUser.getEmail();
            String fullName = oidcUser.getFullName();

            EmployeeContact validateEmail = employeeContactRepository.findByEmployeeEmail(email);

            if(validateEmail==null)
            {
                Employee validateEmployee = employeeRepository.findTopByEmployeeName(fullName);
                if(validateEmployee==null)
                {
                    Employee employee = new Employee();
                    employee.setEmployeeName(fullName);
                    employee.setEmployeeReportsTo(0);

                    Employee savedEmp =  employeeRepository.save(employee);

                    EmployeeContact employeeContact = new EmployeeContact();
                    employeeContact.setEmployeeContact("");
                    employeeContact.setEmployeeEmail(email);
                    employeeContact.setEmployeeId(savedEmp.getEmployeeId());

                    EmployeeContact savedContact = employeeContactRepository.save(employeeContact);

                    if(savedContact!=null && savedEmp!=null)
                    {
                        log.info("data Inserted");
                    }
                    else {
                        log.info("data Not Inserted");
                    }
                }
            }

            System.out.println(oidcUser);
        }
        return "hello, secured";
    }

}
