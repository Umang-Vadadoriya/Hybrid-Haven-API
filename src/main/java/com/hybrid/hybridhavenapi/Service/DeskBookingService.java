package com.hybrid.hybridhavenapi.Service;

import com.hybrid.hybridhavenapi.Entity.DeskBooking;
import com.hybrid.hybridhavenapi.Repository.DeskBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskBookingService {
    @Autowired
    DeskBookingRepository deskBookingRepository;

    public DeskBooking saveDeskBooking(DeskBooking deskBooking) {
        return deskBookingRepository.save(deskBooking);
    }

    public DeskBooking getDeskBookingById(Integer deskBookingId) {
        return deskBookingRepository.findById(deskBookingId).orElse(null);
    }


    public List<DeskBooking> getAllDeskBookings() {
        return deskBookingRepository.findAll();
    }


    public void deleteDeskBooking(Integer deskBookingId) {
        deskBookingRepository.deleteById(deskBookingId);
    }

}
