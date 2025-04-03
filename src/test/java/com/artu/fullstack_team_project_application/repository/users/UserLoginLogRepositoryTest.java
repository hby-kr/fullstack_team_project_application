package com.artu.fullstack_team_project_application.repository.users;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.users.user.UserloginLogs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserLoginLogRepositoryTest {

    @Autowired
    private UserLoginLogRepository userLoginLogRepository;

    @Test
    void save() {
        UserloginLogs userloginLogs = new UserloginLogs();
        userloginLogs.setUserId("user1001");
        userloginLogs.setIpAddress("192.168.1.1");
        userloginLogs.setUserAgent("Mozilla/5.0");
        userloginLogs.setLoginAt(LocalDateTime.now());
        userloginLogs = userLoginLogRepository.save(userloginLogs);
    }
}