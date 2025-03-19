package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.postings.UserFollow;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller //@RestController
@RequestMapping("posting/{userId}")
@AllArgsConstructor
public class UserFollowController {
    private final UserService userService;

    @GetMapping("/follower.do")
    public String follower(
            @PathVariable String userId,
            @RequestParam(required = false) String followerId,
            @RequestParam(required = false) String followeeId,
            Model model
    ) {
        Set<UserFollow> findByFollowerId = userService.findByFollowerId(followerId);
        Set<UserFollow> findByFolloweeId = userService.findByFolloweeId(followeeId);
        Optional<User> userOptional = userService.findByUserId(userId);


        User user = userOptional.get();
        model.addAttribute("user", user);
        model.addAttribute("findByFollowerId", findByFollowerId);
        model.addAttribute("findByFolloweeId", findByFolloweeId);
        return "posting/follower"; // follower.html로 이동
    }


    @GetMapping("/followee.do")
    public String followee(
            @PathVariable String userId,
            @RequestParam(required = false) String followeeId,
            @RequestParam(required = false) String followerId,
            Model model
    ) {
        Set<UserFollow> findByFollowerId = userService.findByFollowerId(followerId);
        Set<UserFollow> findByFolloweeId = userService.findByFolloweeId(followeeId);
        Optional<User> userOptional = userService.findByUserId(userId);


        User user = userOptional.get();
        model.addAttribute("user", user);
        model.addAttribute("findByFollowerId", findByFollowerId);
        model.addAttribute("findByFolloweeId", findByFolloweeId);
        return "posting/followee"; // followee.html로 이동
    }



}
