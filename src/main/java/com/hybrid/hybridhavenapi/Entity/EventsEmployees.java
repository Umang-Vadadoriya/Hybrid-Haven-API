package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
}
