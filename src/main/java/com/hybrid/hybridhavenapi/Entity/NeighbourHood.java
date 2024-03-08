package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class NeighbourHood {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NeighbourId", nullable = false)
    private Integer neighbourId;
    @Basic
    @Column(name = "NeighbourName", nullable = false, length = 30)
    private String neighbourName;
    @Basic
    @Column(name = "NeighbourNumberOfDesk", nullable = false)
    private Integer neighbourNumberOfDesk;
    @OneToMany(mappedBy = "neighbourId")
    private Collection<DeskBooking> deskBookingsByNeighbourId;

    public Integer getNeighbourId() {
        return neighbourId;
    }

    public void setNeighbourId(Integer neighbourId) {
        this.neighbourId = neighbourId;
    }

    public String getNeighbourName() {
        return neighbourName;
    }

    public void setNeighbourName(String neighbourName) {
        this.neighbourName = neighbourName;
    }

    public Integer getNeighbourNumberOfDesk() {
        return neighbourNumberOfDesk;
    }

    public void setNeighbourNumberOfDesk(Integer neighbourNumberOfDesk) {
        this.neighbourNumberOfDesk = neighbourNumberOfDesk;
    }

    public Collection<DeskBooking> getDeskBookingsByNeighbourId() {
        return deskBookingsByNeighbourId;
    }

    public void setDeskBookingsByNeighbourId(Collection<DeskBooking> deskBookingsByNeighbourId) {
        this.deskBookingsByNeighbourId = deskBookingsByNeighbourId;
    }
}
