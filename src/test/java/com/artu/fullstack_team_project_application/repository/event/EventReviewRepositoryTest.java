package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventReviewRepositoryTest {

    @Autowired
    EventReviewRepository eventReviewRepository;

    @Test
    void findByEventId() {
        List<EventReview> eventReview = eventReviewRepository.findByEventId(1);
        System.out.println(eventReview);
    }
}