package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.event.EventImage;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> getAllEvents();
    Optional<Event> get(int id);
    List<Event> getEventsByCategory(int categoryId);
    EventImage getEventWithImages(int eventId);
    List<EventImage> getAllEventWithImages();
    Event createEvent(Event event);
}
