package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.dto.UserPageDto;
import com.artu.fullstack_team_project_application.entity.postings.Posting;
import com.artu.fullstack_team_project_application.entity.postings.UserFollow;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.service.postings.PostingService;
import com.artu.fullstack_team_project_application.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/posting")
@AllArgsConstructor
public class PostingController {
    private final PostingService postingService;
    private final UserService userService;

    @GetMapping("/findAll.do")
    public String findAll(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "/posting/findAll";
    }

    @GetMapping("/{userId}/userpage.do")
    public String userpage(
            @PathVariable String userId,
            Model model) {
        UserPageDto userPageDto=userService.readUserPage(userId);
        System.out.println("userPageDto:" + userPageDto);
        if (userPageDto==null) {
            return "redirect:/artu.do";
        }
        model.addAttribute("userPage", userPageDto);

        // 템플릿에 user, followerCounts, followeeCounts를 전달
        return "/posting/userpage";
    }

    // 게시물 비동기식
    @GetMapping("/{userId}/postpage.do")
    @ResponseBody
    public ResponseEntity<Set<Posting>> postpage(
            @PathVariable String userId) {
        Set<Posting> postings = postingService.findByUserId(userId);
        // return ResponseEntity.ok(postings);
        return ResponseEntity.status(201).body(postings);
    }

    @GetMapping("/{userId}/postAdd.do")
    public String postForm(
            @ModelAttribute Posting posting
    ){
        return "/posting/postAdd";
    }




}
