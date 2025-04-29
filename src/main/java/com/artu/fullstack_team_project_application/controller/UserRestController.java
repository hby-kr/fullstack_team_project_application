package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.jwt.JwtUtil;
import com.artu.fullstack_team_project_application.service.users.CustomUserDetailsService;
import com.artu.fullstack_team_project_application.service.users.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // SPA이고, 그래서 jwt를 로컬저장소에 넣으므로, 앞으로 상태만 보낼거니까. RestController로 구현
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000/"})
public class UserRestController {

    private final UserService userService;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

}
