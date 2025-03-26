package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.event.EventImage;
import com.artu.fullstack_team_project_application.repository.event.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImp implements EventService {

    private final EventRepository eventRepository;

    @Override
    @Transactional(readOnly = true)
    public EventImage getEventWithImages(int eventId) {
        return eventRepository.findEventWithImagesById(eventId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EventImage> getAllEventWithImages() {
        return eventRepository.findAllEventWithImages();
    }

    @Override
    @Transactional
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

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

    @Override
    public List<Event> getEventsByCategory(int ctgrId) {
        return eventRepository.findByCtgrId(ctgrId);
    }
}
