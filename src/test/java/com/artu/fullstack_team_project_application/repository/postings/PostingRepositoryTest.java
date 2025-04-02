package com.artu.fullstack_team_project_application.repository.postings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostingRepositoryTest {
    @Autowired
    PostingRepository postingRepository;
    @Test
    void countpostingByUserId() {
        System.out.println(postingRepository.countpostingByUserId("user1001"));
    }
}