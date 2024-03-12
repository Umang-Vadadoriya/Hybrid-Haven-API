package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.NeighbourHood;
import com.hybrid.hybridhavenapi.Service.NeighbourHoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/neighbourhoods")
public class NeighbourHoodController {
    @Autowired
    private NeighbourHoodService neighbourHoodService;

    @PostMapping
    public ResponseEntity<NeighbourHood> createNeighbourHood(@RequestBody NeighbourHood neighbourHood) {
        NeighbourHood savedNeighbourHood = neighbourHoodService.saveNeighbourHood(neighbourHood);
        return new ResponseEntity<>(savedNeighbourHood, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<NeighbourHood> getNeighbourHoodById(@PathVariable Integer id) {
        NeighbourHood neighbourHood = neighbourHoodService.getNeighbourHoodById(id);
        if (neighbourHood != null) {
            return new ResponseEntity<>(neighbourHood, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<NeighbourHood>> getAllNeighbourHoods() {
        List<NeighbourHood> neighbourHoodList = neighbourHoodService.getAllNeighbourHoods();
        return new ResponseEntity<>(neighbourHoodList, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteNeighbourHood(@PathVariable Integer id) {
        neighbourHoodService.deleteNeighbourHood(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
