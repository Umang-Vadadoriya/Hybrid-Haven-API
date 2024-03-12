package com.hybrid.hybridhavenapi.Service;

import com.hybrid.hybridhavenapi.Entity.Events;
import com.hybrid.hybridhavenapi.Repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventsService {
    @Autowired
    EventsRepository eventsRepository;

    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }

    public Optional<Events> getEventById(Integer eventId) {
        return eventsRepository.findById(eventId);
    }

    public Optional<Events> getEventByName(String name){
        return eventsRepository.findByEventName(name);
    }

    public Events saveEvent(Events event) {
        return eventsRepository.save(event);
    }

    public void deleteEvent(Integer eventId) {
        eventsRepository.deleteById(eventId);
    }

}
