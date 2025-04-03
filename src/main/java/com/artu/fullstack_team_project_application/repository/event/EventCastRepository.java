package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.event.EventCast;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventCastRepository extends CrudRepository<EventCast, Integer> {
    List<EventCast> findByEventId(int eventId);
}
