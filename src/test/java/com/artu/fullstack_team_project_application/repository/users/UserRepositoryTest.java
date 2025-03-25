package com.artu.fullstack_team_project_application.repository.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void existsByUserId() {
        System.out.println(userRepository.existsByUserId("user1"));
    }

    @Test
    void existsByUserEmail() {
        System.out.println(userRepository.existsByUserEmail("user1@artu.com"));
    }
}