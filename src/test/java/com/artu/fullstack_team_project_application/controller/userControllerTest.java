package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.service.users.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class userControllerTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    void authenticate() {


    }
}