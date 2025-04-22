package com.artu.fullstack_team_project_application.repository.tickets;

import com.artu.fullstack_team_project_application.entity.events.tickets.EventDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDateRepository extends JpaRepository<EventDate, Integer> {
    List<EventDate> findByEventId(Integer eventId);
}
