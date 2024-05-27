package com.hybrid.hybridhavenapi.Service;

import com.hybrid.hybridhavenapi.Entity.DeskBooking;
import com.hybrid.hybridhavenapi.Repository.DeskBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<DeskBooking> getDeskBookingByDate(Date date) {
        return deskBookingRepository.findByDeskBookingDate(date);
    }

    public boolean hasDeskBooking(Integer id){
        DeskBooking deskBooking = getDeskBookingById(id);
        return deskBooking != null;
    }

    public boolean hasDeskBooking(Integer employeeId,Date deskBookingDate){
        DeskBooking deskBooking = deskBookingRepository.findDeskBookingByEmployeeIdAndDeskBookingDate(employeeId,deskBookingDate);
        return deskBooking != null;
    }


}
