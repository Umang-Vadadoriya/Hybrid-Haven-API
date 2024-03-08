package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity

public class DeskBooking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DeskBookingId", nullable = false)
    private Integer deskBookingId;
    @Basic
    @Column(name = "EmployeeId", nullable = false)
    private Integer employeeId;
    @Basic
    @Column(name = "NeighbourId", nullable = false)
    private Integer neighbourId;
    @Basic
    @Column(name = "DeskBookingDate", nullable = false)
    private Date deskBookingDate;

    protected DeskBooking(){}

    public Integer getDeskBookingId() {
        return deskBookingId;
    }

    public void setDeskBookingId(Integer deskBookingId) {
        this.deskBookingId = deskBookingId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getNeighbourId() {
        return neighbourId;
    }

    public void setNeighbourId(Integer neighbourId) {
        this.neighbourId = neighbourId;
    }

    public Date getDeskBookingDate() {
        return deskBookingDate;
    }

    public void setDeskBookingDate(Date deskBookingDate) {
        this.deskBookingDate = deskBookingDate;
    }
}
