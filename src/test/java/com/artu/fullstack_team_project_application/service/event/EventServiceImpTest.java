package com.artu.fullstack_team_project_application.service.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventServiceImpTest {

    @Autowired
    EventService eventService;

    @Test
    void getEventsByCategory() {
        System.out.println(eventService.getEventsByCategory((byte) 4));
    }
}