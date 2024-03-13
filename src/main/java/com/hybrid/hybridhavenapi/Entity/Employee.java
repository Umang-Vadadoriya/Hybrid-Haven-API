package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EmployeeId", nullable = false)
    private Integer employeeId;

    @Column(name = "EmployeeName", nullable = false, length = 50)
    private String employeeName;

    @Column(name = "EmployeeReportsTo", nullable = false)
    private Integer employeeReportsTo;

    @OneToMany(mappedBy = "employeeId")
    private Collection<EmployeeContact> employeeContactsByEmployeeId;

//    @OneToMany(mappedBy = "employeeId")
//    private Collection<DeskBooking> deskBookingsByEmployeeId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeReportsTo() {
        return employeeReportsTo;
    }

    public void setEmployeeReportsTo(Integer employeeReportsTo) {
        this.employeeReportsTo = employeeReportsTo;
    }

    public Collection<EmployeeContact> getEmployeeContactsByEmployeeId(){
        return employeeContactsByEmployeeId;
    }

    public void setEmployeeContactsByEmployeeId(Collection<EmployeeContact> employeesContactByEmployeeId){
        this.employeeContactsByEmployeeId = employeesContactByEmployeeId;
    }

//    public Collection<DeskBooking> getDeskBookingsByEmployeeId() {
//        return deskBookingsByEmployeeId;
//    }
//
//    public void setDeskBookingsByEmployeeId(Collection<DeskBooking> deskBookingsByEmployeeId) {
//        this.deskBookingsByEmployeeId = deskBookingsByEmployeeId;
//    }


}
