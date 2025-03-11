package com.artu.fullstack_team_project_application.repository.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventReviewImageRepositoryTest {
    @Autowired
    EventReviewImageRepository eventReviewImageRepository;
    @Test
    void findByUserId() {
        System.out.println(eventReviewImageRepository.findByUser_UserId("1"));
    }
}