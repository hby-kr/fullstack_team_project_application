package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.dto.UserPageDto;
import com.artu.fullstack_team_project_application.entity.postings.Posting;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.service.postings.PostingService;
import com.artu.fullstack_team_project_application.service.users.UserService;
import com.artu.fullstack_team_project_application.service.widgets.WidgetDetailService;
import com.artu.fullstack_team_project_application.service.widgets.WidgetService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/posting")
@AllArgsConstructor
public class PostingController {
    private final PostingService postingService;
    private final UserService userService;

    @GetMapping("/findAll.do")
    public String findAll(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user); // 세션관리

        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        model.addAttribute("headerNav", "personal");

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


    @RestController
    @RequestMapping("/api/widgets")
    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    public static class WidgetController {

        private final WidgetService widgetService;
        private final WidgetDetailService widgetDetailService;

        @Autowired
        public WidgetController(WidgetService widgetService, WidgetDetailService widgetDetailService) {
            this.widgetService = widgetService;
            this.widgetDetailService = widgetDetailService;
        }

        @GetMapping("/all")
        public ResponseEntity<List<Map<String, Object>>> getAllWidgets() {
            return ResponseEntity.ok(widgetService.getAllWidgets());
        }

        @GetMapping("/used")
        public ResponseEntity<List<Map<String, Object>>> getUsedWidgetsByUserId(@RequestParam String userId) {
            return ResponseEntity.ok(widgetDetailService.getUserWidgets(userId));
        }

        @PostMapping("/order")
        public ResponseEntity<String> updateWidgetOrder(@RequestBody List<Map<String, Object>> orderList) {
            widgetDetailService.updateWidgetOrder(orderList);
            return ResponseEntity.ok("순서 저장 완료");
        }

        @DeleteMapping("/delete/{widgetId}")
        public ResponseEntity<String> deleteWidget(@PathVariable Integer widgetId, @RequestParam String userId) {
            widgetDetailService.deleteWidget(userId, widgetId);
            return ResponseEntity.ok("삭제 완료");
        }
    }
}
