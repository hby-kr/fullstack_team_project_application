package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Optional<Actor> findById(Integer id);

}
