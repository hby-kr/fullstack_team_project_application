package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.repository.event.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceCategoryImp implements EventServiceCategory {

    private final EventRepository eventRepositoryCategory;

    public EventServiceCategoryImp(EventRepository eventRepository) {
        this.eventRepositoryCategory = eventRepository;
    }

    @Override
    public List<Event> getEventsByCategory(int categoryId) {
        return List.of();
    }
}