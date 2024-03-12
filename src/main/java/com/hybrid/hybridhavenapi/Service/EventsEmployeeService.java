package com.hybrid.hybridhavenapi.Service;

import com.hybrid.hybridhavenapi.Entity.EventsEmployees;
import com.hybrid.hybridhavenapi.Repository.EventsEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsEmployeeService {
    @Autowired
    EventsEmployeeRepository eventsEmployeesRepository;

    public EventsEmployees saveEventsEmployees(EventsEmployees eventsEmployees) {
        return eventsEmployeesRepository.save(eventsEmployees);
    }

    public EventsEmployees getEventsEmployeesById(Integer eventEmployeeId) {
        return eventsEmployeesRepository.findById(eventEmployeeId).orElse(null);
    }

    public List<EventsEmployees> getAllEventsEmployees() {
        return eventsEmployeesRepository.findAll();
    }

    public void deleteEventsEmployees(Integer eventEmployeeId) {
        eventsEmployeesRepository.deleteById(eventEmployeeId);
    }

}
