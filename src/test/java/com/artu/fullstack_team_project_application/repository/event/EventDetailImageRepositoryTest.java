package com.artu.fullstack_team_project_application.repository.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventDetailImageRepositoryTest {
    @Autowired
    EventDetailImageRepository eventDetailImageRepository;
    @Test
    @Transactional
    void findByEventId() {
        System.out.println(eventDetailImageRepository.findByEventId(1));
    }
}