package com.artu.fullstack_team_project_application.controller;

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

        Optional<User> userOptional = userService.readOne(userId);
        System.out.println("userOptional:" + userOptional);
        if (!userOptional.isPresent()) {
            return "redirect:/artu.do";
        }

        User user = userOptional.get();
        model.addAttribute("user", user);  // user 객체를 모델에 담기
        model.addAttribute("userId", userId);  // userId도 모델에 담기

        // followee 수
        Map<String, Long> countFolloweeMap = userService.getCountFollowee(userId);
        Long countFolloweeCount = countFolloweeMap.get("countFollowee");
        model.addAttribute("countFolloweeMap", countFolloweeMap);
        model.addAttribute("countFolloweeCount", countFolloweeCount);

        // follower 수
        Map<String, Long> countFollowerMap = userService.getCountFollower(userId);
        Long countFollowerCount = countFollowerMap.get("countFollower");
        model.addAttribute("countFollowerMap", countFollowerMap);
        model.addAttribute("countFollowerCount", countFollowerCount);

        // posting 수
        Map<String, Long> countPostingMap = userService.getCountPosting(userId);
        Long countPostingCount = countPostingMap.get("countPosting");
        model.addAttribute("countPostingMap", countPostingMap);
        model.addAttribute("countPostingCount", countPostingCount);

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
