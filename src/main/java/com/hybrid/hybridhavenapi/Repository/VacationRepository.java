package com.hybrid.hybridhavenapi.Repository;

import com.hybrid.hybridhavenapi.Entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation,Integer> {
    @Query("SELECT v FROM Vacation v WHERE :date BETWEEN v.vacationStartDate AND v.vacationEndDate")
    List<Vacation> findVacationsByDate(Date date);

    @Query("SELECT v FROM Vacation v WHERE v.employeeId = :employeeId AND (v.vacationStartDate BETWEEN :startDate AND :endDate OR v.vacationEndDate BETWEEN :startDate AND :endDate)")
    List<Vacation> findVacationByEmployeeIdAndDateRange(Integer employeeId, Date startDate, Date endDate);
}
