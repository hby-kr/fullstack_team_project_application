package com.artu.fullstack_team_project_application.repository.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventReviewImageRepositoryTest {
    @Autowired
    EventReviewImageRepository eventReviewImageRepository;
//    @Test
//    @Transactional
//    void findByUserId() {
//        System.out.println(eventReviewImageRepository.findByUser_UserId("user1"));
//    }
}