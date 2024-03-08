package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;

@Entity
public class EventsEmployees {
    @Basic
    @Column(name = "EventId", nullable = false)
    private Integer eventId;
    @Basic
    @Column(name = "EmployeeId", nullable = false)
    private Integer employeeId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EventEmployeeId", nullable = false)
    private Integer eventEmployeeId;
    @ManyToOne
    @JoinColumn(name = "EventId", referencedColumnName = "EventID", nullable = false, updatable = false, insertable = false)
    private Events eventsByEventId;
    @ManyToOne
    @JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId", nullable = false,updatable = false, insertable = false)
    private Employee employeeByEmployeeId;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEventEmployeeId() {
        return eventEmployeeId;
    }

    public void setEventEmployeeId(Integer eventEmployeeId) {
        this.eventEmployeeId = eventEmployeeId;
    }

    public Events getEventsByEventId() {
        return eventsByEventId;
    }

    public void setEventsByEventId(Events eventsByEventId) {
        this.eventsByEventId = eventsByEventId;
    }

    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }
}
