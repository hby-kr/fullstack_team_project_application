package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.Actor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActorRepositoryTest {

    @Autowired
    ActorRepository actorRepository;

    @Test
    void findById() {
        Optional<Actor> actor = actorRepository.findById(1);
        System.out.println(actor.get());
    }
}