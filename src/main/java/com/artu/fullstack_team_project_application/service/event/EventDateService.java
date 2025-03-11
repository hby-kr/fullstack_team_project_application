package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.tickets.EventDate;
import com.artu.fullstack_team_project_application.repository.event.EventDateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventDateService {
    private final EventDateRepository eventDateRepository;


    public List<EventDate> getAllEvents() {
        return eventDateRepository.findAll();
    }

    public Optional<EventDate> getEventById(Integer id) {
        return eventDateRepository.findById(id);
    }

    public EventDate save(EventDate event) {
        return eventDateRepository.save(event);
    }

    public void deleteEvent(Integer id) {
         eventDateRepository.deleteById(id);
    }

    public Instant getMinStartDate() {
        return eventDateRepository.findMinEventDate();
    }
    public LocalDateTime getMaxStartDate() {
        return eventDateRepository.findMaxEndDate();
    }
}

