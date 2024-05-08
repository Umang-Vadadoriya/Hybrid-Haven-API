package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
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

    /*    @OneToMany(mappedBy = "employeeId")
    private Collection<DeskBooking> deskBookingsByEmployeeId;
    }*/


}
