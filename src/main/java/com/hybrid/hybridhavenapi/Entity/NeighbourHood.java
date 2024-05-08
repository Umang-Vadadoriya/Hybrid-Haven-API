package com.hybrid.hybridhavenapi.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
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
}
