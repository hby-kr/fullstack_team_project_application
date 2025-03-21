package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.repository.event.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImp implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImp(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> get(int id) {
        return eventRepository.findById(id);
    }
}
