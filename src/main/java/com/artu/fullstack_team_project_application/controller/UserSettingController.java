package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.users.user.UserSetting;
import com.artu.fullstack_team_project_application.service.users.UserService;
import com.artu.fullstack_team_project_application.service.users.UserSettingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

//@Controller
@RestController
@RequestMapping("posting/{userId}")
@AllArgsConstructor
public class UserSettingController {
    private final UserSettingService userSettingService;
    private final UserService userService;

    @GetMapping("setting.do")
    public ResponseEntity<UserSetting> getSetting(
            @PathVariable String userId
    ){
        Optional<UserSetting> findOne = userSettingService.findOne(userId);
        Optional<User> userOptional = userService.findByUserId(userId);
        User user = userOptional.get();
        UserSetting userSetting = findOne.orElse(new UserSetting());
        userSetting.setUser(user);
        return ResponseEntity.ok(userSetting);
    }

    @PostMapping("setting.do")
    public ResponseEntity<UserSetting> saveUserSetting(
            @PathVariable String userId,
            @RequestBody UserSetting userSetting
    ){
        User user = userService.findByUserId(userId).orElseThrow(() -> new RuntimeException("없음"));
        UserSetting setting = userSettingService.findOne(userId).orElse(new UserSetting());

        setting.setUser(user);
        setting.setDisplayColor(userSetting.getDisplayColor());
        setting.setLanguage(userSetting.getLanguage());
        setting.setSetAt(Instant.now());
        userSettingService.save(setting);

        return ResponseEntity.ok(setting);
    }
}
