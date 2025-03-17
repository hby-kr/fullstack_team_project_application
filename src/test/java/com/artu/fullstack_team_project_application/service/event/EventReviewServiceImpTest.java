package com.artu.fullstack_team_project_application.service.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventReviewServiceImpTest {
    @Autowired
    private EventReviewService eventReviewService;
    @Test
    @Transactional
    void getReviewsByEventId() {
        System.out.println(eventReviewService.getReviewsByEventId(1));
    }

    @Test
    @Transactional
    void getReviewsByUserId() {
        System.out.println(eventReviewService.getReviewsByUserId("user1"));

    }

    @Test
    @Transactional
    void getAllEventReviews() {
        System.out.println(eventReviewService.getAllEventReviews());
    }
}