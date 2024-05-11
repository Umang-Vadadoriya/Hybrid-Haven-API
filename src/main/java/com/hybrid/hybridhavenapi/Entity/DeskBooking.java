package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
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
}
