package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.EventDetailImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDetailImageRepository extends JpaRepository<EventDetailImage, Integer> {
    List<EventDetailImage> findByEventId(int eventId);
}
