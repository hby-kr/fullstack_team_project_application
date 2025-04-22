package com.artu.fullstack_team_project_application.service.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventServiceImpTest {

    @Autowired
    EventService eventService;

    @Test
    void getEventsAllByCategory() {
        System.out.println(eventService.getEventsAllByCategory((byte) 4));
    }

    @Test
    void getEventById() {
        System.out.println(eventService.getEventById(99));
    }
}