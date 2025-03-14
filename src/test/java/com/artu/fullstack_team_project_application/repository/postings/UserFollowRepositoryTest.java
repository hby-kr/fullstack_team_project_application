package com.artu.fullstack_team_project_application.repository.postings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserFollowRepositoryTest {
    @Autowired
    private UserFollowRepository userFollowRepository;

    @Test
    void findByFollowerId() {
        System.out.println(userFollowRepository.findByFollowerId("user1"));
    }

    @Test
    void findByFolloweeId() {
        System.out.println(userFollowRepository.findByFollowerId("user1"));
    }
}