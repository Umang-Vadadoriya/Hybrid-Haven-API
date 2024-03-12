package com.hybrid.hybridhavenapi.Service;

import com.hybrid.hybridhavenapi.Entity.Vacation;
import com.hybrid.hybridhavenapi.Repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationService {
    @Autowired
    private VacationRepository vacationRepository;

    public Vacation saveVacation(Vacation vacation) {
        return vacationRepository.save(vacation);
    }

    public Vacation getVacationById(Integer vacationId) {
        return vacationRepository.findById(vacationId).orElse(null);
    }

    public List<Vacation> getAllVacations() {
        return vacationRepository.findAll();
    }

    public void deleteVacation(Integer vacationId) {
        vacationRepository.deleteById(vacationId);
    }

}
