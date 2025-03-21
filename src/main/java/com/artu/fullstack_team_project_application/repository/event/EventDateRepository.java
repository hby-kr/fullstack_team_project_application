package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.tickets.EventDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;

@Repository
public interface EventDateRepository extends JpaRepository<EventDate, Integer> {
    @Query("SELECT MIN(e.eventDate) FROM EventDate e")
    Instant findMinEventDate();

    @Query("SELECT MAX(e.eventDate) FROM EventDate e")
    LocalDateTime findMaxEndDate();

    EventDate findTopByEventIdOrderByEventDateAsc(Integer eventId);
}
