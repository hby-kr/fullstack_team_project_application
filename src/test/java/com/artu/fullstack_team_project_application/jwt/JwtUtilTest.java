package com.artu.fullstack_team_project_application.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtUtilTest {

    @Autowired
    JwtUtil jwtUtil;

    @Test
    void generateToken() {
        String jwt = jwtUtil.generateToken("admin");
        System.out.println(jwt);
    }
}