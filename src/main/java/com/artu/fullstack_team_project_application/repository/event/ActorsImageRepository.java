package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.ActorsImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorsImageRepository extends JpaRepository<ActorsImage, Integer> {

    List<ActorsImage> findAllByActorId(Integer actorId);


}
