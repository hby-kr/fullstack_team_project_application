package com.artu.fullstack_team_project_application.service.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventReviewImageServiceImpTest {
    @Autowired
    EventReviewImageService eventReviewImageService;

    @Test
    @Transactional
    void getImagesByUserId() {
        System.out.println(eventReviewImageService.getImagesByUserId("user1"));
    }

    @Test
    @Transactional
    void getImageById() {
        System.out.println(eventReviewImageService.getImageById(1));
    }

    @Test
    void saveImage() {
    }

    @Test
    void deleteImage() {
    }
}