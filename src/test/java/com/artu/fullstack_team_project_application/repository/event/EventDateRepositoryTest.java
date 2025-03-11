package com.artu.fullstack_team_project_application.repository.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class EventDateRepositoryTest {
    @Autowired
    EventDateRepository eventRepository;
    @Test
    @Transactional
    void findMinEventDate() {
        System.out.println(eventRepository.findMinEventDate());

    }

    @Test
    void findMaxEndDate() {
    }

    @Test
    @Transactional
    void findTopByEventIdOrderByEventDateAsc() {
        System.out.println(eventRepository.findTopByEventIdOrderByEventDateAsc(1));
    }
}