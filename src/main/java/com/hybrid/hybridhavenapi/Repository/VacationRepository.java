package com.hybrid.hybridhavenapi.Repository;

import com.hybrid.hybridhavenapi.Entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation,Integer> {
    @Query("SELECT v FROM Vacation v WHERE :date BETWEEN v.vacationStartDate AND v.vacationEndDate")
    public List<Vacation> findVacationsByDate(Date date);
}
