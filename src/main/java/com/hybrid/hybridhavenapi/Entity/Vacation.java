package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Vacation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "VacationId", nullable = false)
    private Integer vacationId;
    @Basic
    @Column(name = "EmployeeId", nullable = false)
    private Integer employeeId;
    @Basic
    @Column(name = "VacationStartDate", nullable = false)
    private Date vacationStartDate;
    @Basic
    @Column(name = "VacationEndDate", nullable = false)
    private Date vacationEndDate;
    @ManyToOne
    @JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId", nullable = false, updatable = false, insertable = false)
    private Employee employeeByEmployeeId;
}
