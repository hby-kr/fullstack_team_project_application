package com.artu.fullstack_team_project_application.service.users;

import com.artu.fullstack_team_project_application.dto.UserPageDto;
import com.artu.fullstack_team_project_application.dto.users.LoginRequestDto;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Test
    void updatePassword() {
        userService.updatePassword("user1001", "1234");

    }

    @Test
    void loginHashCheck() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setId("user1010");
        loginRequestDto.setPw("1234");
        Optional<User> userOpt = userService.loginHashCheck(loginRequestDto);
        System.out.println(userOpt.get());
    }
}