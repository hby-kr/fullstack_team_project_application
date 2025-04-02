package com.artu.fullstack_team_project_application.service.users;

import com.artu.fullstack_team_project_application.dto.UserPageDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImpTest {
    @Autowired
    UserService userService;
    @Test
    @Transactional
    void readUserPage() {
        UserPageDto userPageDto = new UserPageDto();
        System.out.println(userService.readUserPage("user1001"));
    }
}