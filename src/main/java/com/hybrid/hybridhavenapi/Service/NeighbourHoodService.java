package com.hybrid.hybridhavenapi.Service;

import com.hybrid.hybridhavenapi.Entity.NeighbourHood;
import com.hybrid.hybridhavenapi.Repository.NeighbourHoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeighbourHoodService {

    @Autowired
    private NeighbourHoodRepository neighbourHoodRepository;


    public NeighbourHood saveNeighbourHood(NeighbourHood neighbourHood) {
        return neighbourHoodRepository.save(neighbourHood);
    }


    public NeighbourHood getNeighbourHoodById(Integer neighbourId) {
        return neighbourHoodRepository.findById(neighbourId).orElse(null);
    }


    public List<NeighbourHood> getAllNeighbourHoods() {
        return neighbourHoodRepository.findAll();
    }


    public void deleteNeighbourHood(Integer neighbourId) {
        neighbourHoodRepository.deleteById(neighbourId);
    }
}
