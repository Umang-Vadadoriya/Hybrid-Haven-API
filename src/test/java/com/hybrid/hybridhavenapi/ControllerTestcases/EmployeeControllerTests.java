package com.hybrid.hybridhavenapi.ControllerTestcases;

import com.hybrid.hybridhavenapi.Controller.EmployeeController;
import com.hybrid.hybridhavenapi.Entity.Employee;
import com.hybrid.hybridhavenapi.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(EmployeeController.class)
@ExtendWith(SpringExtension.class)
public class EmployeeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;


    @Test
    public void getAllEmployeeTest_Exception() throws Exception{

        Mockito.when(employeeService.getAllEmployees()).thenThrow(new RuntimeException("Error retrieving employees"));

        // Perform GET request to fetch all employees and expect an internal server error
        mockMvc.perform(get("/employees"))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().string("Error retrieving employees"));

    }

    @Test
    public void testGetAllEmployees() throws Exception {
        // Create sample employees

        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setEmployeeName("krunal");

        Employee employee2 = new Employee();
        employee1.setEmployeeId(2);
        employee1.setEmployeeName("Umang");


        List<Employee> employees = Arrays.asList(employee1,employee2);

        // Mock the service method to return sample employees
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        // Perform GET request to fetch all employees
        MvcResult result =  mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andReturn();


        log.info(result.getResponse().getContentAsString());


    }

    @Test
    public void testGetEmployeeByName() throws Exception {
        // Create sample employees
        Employee employee1 = new Employee();
        employee1.setEmployeeId(9);
        employee1.setEmployeeName("Nisha Jain");


        List<Employee> employees = List.of(employee1);


        // Mock the service method to return sample employees with the specified name
        Mockito.when(employeeService.getEmployeeByName("Nisha Jain")).thenReturn(employees);

        // Perform GET request to fetch employees by name
        MvcResult result = mockMvc.perform(get("/employees/name/Nisha Jain"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].employeeName").value("Nisha Jain"))
                .andReturn();

        log.info(result.getResponse().getContentAsString());

    }

}
