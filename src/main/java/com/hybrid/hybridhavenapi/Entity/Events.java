package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Events {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EventID", nullable = false)
    private Integer eventId;
    @Basic
    @Column(name = "EventName", nullable = false, length = 50)
    private String eventName;
    @Basic
    @Column(name = "EventDescription", nullable = true, length = 300)
    private String eventDescription;
    @Basic
    @Column(name = "EventDate", nullable = false)
    private Date eventDate;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
