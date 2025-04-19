package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventRepositoryTest {

    @Autowired
    EventRepository eventRepository;

    @Test
    void findByCtgrId() {
        Pageable pageable = PageRequest.of(0, 4);
        List<Event> events = eventRepository.findByCtgrId((byte) 1,pageable);
        System.out.println(events);

    }
}