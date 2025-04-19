package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.repository.event.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImp implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<Event> getEventsByCategory(byte ctgrId) {
     return eventRepository.findByCtgrId(ctgrId);
    }
}