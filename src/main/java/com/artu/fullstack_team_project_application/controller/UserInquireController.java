package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.users.base.UserInquire;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.service.users.UserInquireService;
import com.artu.fullstack_team_project_application.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@Controller
@RestController
@RequestMapping("/inquire")
@AllArgsConstructor
public class UserInquireController {
    private final UserInquireService userInquireService;
    private final UserService userService;

    @PostMapping("/{userId}/inquire.do")
    public ResponseEntity<UserInquire> updateInquire(
            @PathVariable String userId,
            @ModelAttribute UserInquire userInquire
    ){
        User user = userService.readOne(userId).get();
        userInquire.setUser(user);
        userInquireService.save(userInquire);
        return ResponseEntity.ok(userInquire);
    }

    @DeleteMapping("/{userId}/inquires.do")
    public ResponseEntity<String> deleteInquires(
            @PathVariable String userId,
            @RequestParam(required = false) Integer inquireId
    ){
        userInquireService.delete(userId, inquireId);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/{userId}/myinquire.do")
    public ResponseEntity<Set<UserInquire>> myInquires(
            @PathVariable String userId
    ){
        Optional<User> userOptional = userService.readOne(userId);
        System.out.println(">>> 오류 myInquires called with userId = " + userId);
        User user = userOptional.get();
        Set<UserInquire> userInquires = userInquireService.findInquireByUserId(userId);
        return ResponseEntity.ok(userInquires);
    }

    @GetMapping("/{userId}/inquirecate.do")
    public ResponseEntity<Map<String, Object>> InqCateResponse(
            @PathVariable  String userId,
            @RequestParam  UserInquire.InquireCategory inquireCategory
    ){
        Set<UserInquire> inquiresCate = userInquireService.findInquireByInquireCategory(inquireCategory);
        Map<String, Object> result = new HashMap<>();
        result.put("inquiresCate", inquiresCate);
        Optional<User> userOptional = userService.readOne(userId);
        User user = userOptional.get();
        result.put("user", user);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{userId}/findAll.do")
    public ResponseEntity<Map<String, Object>> getInquires(@PathVariable String userId) {
        List<UserInquire> inquires = userInquireService.findAll();
        Optional<User> userOptional = userService.readOne(userId);
        User user = userOptional.get();

        Map<String, Object> result = new HashMap<>();
        result.put("inquires", inquires);  // 직접 엔티티 리스트 담기
        result.put("user", user);

        return ResponseEntity.ok(result);
    }

}

