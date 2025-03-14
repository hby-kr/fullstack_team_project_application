package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.postings.UserFollow;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.service.postings.PostingService;
import com.artu.fullstack_team_project_application.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/posting")
@AllArgsConstructor
public class PostingController {
    private final PostingService postingService;
    private final UserService userService;

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

        // 템플릿에 user, followerCounts, followeeCounts를 전달
        return "posting/userpage";
    }
//
//    @GetMapping("/{userId}/follower.do")
//    public String follower(String followerId, Model model) {
//        List<UserFollow> findByFollowerId = userService.findByFollowerId(followerId);
//        model.addAttribute("followerId", findByFollowerId); // 팔로워 리스트를 모델에 추가
//        return "artu/follower"; // follower.html로 이동
//    }
//
//    @GetMapping("/{userId}/followee.do")
//    public String followee(String followeeId, Model model) {
//        List<UserFollow> findByFolloweeId = userService.findByFolloweeId(followeeId);
//        model.addAttribute("followeeId", findByFolloweeId); // 팔로우된 리스트를 모델에 추가
//        return "artu/followee"; // followee.html로 이동
//    }

}
