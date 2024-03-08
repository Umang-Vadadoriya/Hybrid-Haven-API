package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;

import java.sql.Date;

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

    public Integer getVacationId() {
        return vacationId;
    }

    public void setVacationId(Integer vacationId) {
        this.vacationId = vacationId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(Date vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public Date getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(Date vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }
}
