package com.artu.fullstack_team_project_application.repository.tickets;

import com.artu.fullstack_team_project_application.entity.events.tickets.EventOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventOptionRepository extends JpaRepository<EventOption, Integer> {
    List<EventOption> findByDate_DateId(Integer dateId);
}

