package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.event.EventImage;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> getEventsByCategory(byte ctgrId);

}