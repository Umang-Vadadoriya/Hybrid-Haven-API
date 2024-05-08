package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EmployeeContact {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EmployeeContactId", nullable = false)
    private Integer employeeContactId;

    @Column(name = "EmployeeId", nullable = false)
    private Integer employeeId;

    @Column(name = "EmployeeEmail", nullable = false, length = 50)
    private String employeeEmail;

    @Column(name = "EmployeeContact", nullable = false, length = 13)
    private String employeeContact;

//    @ManyToOne
//    @JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId", nullable = false, insertable = false, updatable = false)
//    private Employee employeeByEmployeeId;

//    public Employee getEmployeeByEmployeeId() {
//        return employeeByEmployeeId;
//    }
//
//    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
//        this.employeeByEmployeeId = employeeByEmployeeId;
//    }
}
