package com.hybrid.hybridhavenapi.Service;

import com.hybrid.hybridhavenapi.Entity.Employee;
import com.hybrid.hybridhavenapi.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

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
}
