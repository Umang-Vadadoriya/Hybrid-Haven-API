package com.hybrid.hybridhavenapi.Repository;

import com.hybrid.hybridhavenapi.Entity.DeskBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DeskBookingRepository extends JpaRepository<DeskBooking,Integer> {
    List<DeskBooking> findByDeskBookingDate(Date date);

    DeskBooking findDeskBookingByEmployeeIdAndDeskBookingDate(Integer employeeId,Date deskBookingDate);
}
