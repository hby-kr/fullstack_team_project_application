package com.artu.fullstack_team_project_application.repository.postings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserFollowRepositoryTest {
    @Autowired
    private UserFollowRepository userFollowRepository;

    @Test
    @Transactional
    void findByFollowerId() {
        System.out.println(userFollowRepository.findByFollowerId("user1001"));
    }

    @Test
    @Transactional
    void findByFolloweeId() {
        System.out.println(userFollowRepository.findByFolloweeId("user1001"));
    }

    @Test
    void countFolloweeByUserId() {
        System.out.println(userFollowRepository.countFolloweeByUserId("user1001"));
    }

    @Test
    void countFollowerByUserId() {
        System.out.println(userFollowRepository.countFollowerByUserId("user1001"));
    }
}