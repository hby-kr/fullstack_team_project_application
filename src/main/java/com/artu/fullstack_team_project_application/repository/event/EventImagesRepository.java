package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.EventImage;
import org.springframework.data.repository.CrudRepository;

public interface EventImagesRepository extends CrudRepository<EventImage, Integer> {
}
