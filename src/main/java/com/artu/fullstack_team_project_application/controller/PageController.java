package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    // 임시 웹사이트용
    @GetMapping("/fragments/widget/widget.do")
    public String showWidgetPage( Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user); // 세션관리

        model.addAttribute("headerNav", "widget");
        return "/fragments/widget/widget";
    }
}
