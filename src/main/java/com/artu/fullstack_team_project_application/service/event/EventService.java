package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventService {

    Optional<Event> getEventById(int id);

    List<Event> getEventsAllByCategory(byte ctgrId);

    List<Event> getEventsByCategoryForMain(byte ctgrId, Pageable pageable);



}