package com.hybrid.hybridhavenapi.Controller;

import com.hybrid.hybridhavenapi.Entity.Events;
import com.hybrid.hybridhavenapi.Service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventsController {

    @Autowired
    EventsService eventsService;

    @GetMapping("events")
    public List<Events> getAllEvents(){

        return eventsService.getAllEvents();
    }

    @GetMapping("events/{eventId}")
    public ResponseEntity<Optional<Events>> getEventById(@PathVariable Integer eventId)
    {
        return ResponseEntity.ok().body(eventsService.getEventById(eventId));
    }


    @GetMapping("events/eventname/{eventName}")
    public ResponseEntity<Optional<Events>> getEventByName(@PathVariable String eventName){
        return ResponseEntity.ok().body(eventsService.getEventByName(eventName));
    }

    @DeleteMapping("events/id/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        eventsService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("events")
    public ResponseEntity<Events> createEvent(@RequestBody Events event) {
        Events savedEvent = eventsService.saveEvent(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @PutMapping("events/id/{id}")
    public ResponseEntity<Events> updateEvent(@PathVariable Integer id, @RequestBody Events event) {
        event.setEventId(id);
        Events updatedEvent = eventsService.saveEvent(event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

}
