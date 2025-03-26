package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.events.event.EventImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByCtgrId(int ctgrId);

    @Query("SELECT e FROM EventImage e LEFT JOIN FETCH e.imgUrl WHERE e.id = :eventId")
    EventImage findEventWithImagesById(int eventId);

    @Query("SELECT e FROM EventImage e LEFT JOIN FETCH e.imgUrl")
    List<EventImage> findAllEventWithImages();
}
