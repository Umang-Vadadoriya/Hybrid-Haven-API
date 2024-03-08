package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;

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

    public Integer getEmployeeContactId() {
        return employeeContactId;
    }

    public void setEmployeeContactId(Integer employeeContactId) {
        this.employeeContactId = employeeContactId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

//    public Employee getEmployeeByEmployeeId() {
//        return employeeByEmployeeId;
//    }
//
//    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
//        this.employeeByEmployeeId = employeeByEmployeeId;
//    }
}
