package com.artu.fullstack_team_project_application.service.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventReviewServiceImpTest {
    @Autowired
    private EventReviewService eventReviewService;
    @Test
    void getReviewsByEventId() {
        System.out.println(eventReviewService.getReviewsByEventId(1));
    }

    @Test
    void getReviewsByUserId() {
        System.out.println(eventReviewService.getReviewsByUserId(1));
    }
}