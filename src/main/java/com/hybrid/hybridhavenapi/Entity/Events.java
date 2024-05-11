package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Events {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EventID", nullable = false)
    private Integer eventId;
    @Basic
    @Column(name = "EventName", nullable = false, length = 50)
    private String eventName;
    @Basic
    @Column(name = "EventDescription", length = 300)
    private String eventDescription;
    @Basic
    @Column(name = "EventDate", nullable = false)
    private Date eventDate;
}
