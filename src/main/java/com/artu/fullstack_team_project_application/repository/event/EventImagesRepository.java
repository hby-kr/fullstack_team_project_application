package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.EventImage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventImagesRepository extends CrudRepository<EventImage, Integer> {
    List<EventImage> findByEventId(int eventId);
}
