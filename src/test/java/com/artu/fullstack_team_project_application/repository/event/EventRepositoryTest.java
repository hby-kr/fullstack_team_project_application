package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventRepositoryTest {
    @Autowired
    private EventRepository eventRepository;

    @Test
    void getAllEvents() {
        List<Event> events = eventRepository.findAll();
        assertNotNull(events);
        assertTrue(events.size() > 0);
    }

    @Test
    void findByCategoryId() {
        List<Event> events = eventRepository.findByCtgrId(1);
    }
}