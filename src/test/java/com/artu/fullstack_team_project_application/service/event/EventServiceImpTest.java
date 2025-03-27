package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventServiceImpTest {
    @Autowired
    private EventService eventServiceImp;

    @Test
    void getAllEvents() {
        List<Event> events = eventServiceImp.getAllEvents();
        System.out.println(events);
    }

    @Test
    @Transactional
    void get() {
        Optional<Event> eventOpt = eventServiceImp.get(1);
        Event event = eventOpt.get();
        System.out.println(event);

    }

    @Test
    @Transactional
    void getEventsByCategory() {
        List<Event> events = eventServiceImp.getEventsByCategory(1);
        System.out.println(events);
    }
}
