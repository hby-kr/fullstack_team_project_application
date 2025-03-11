package com.artu.fullstack_team_project_application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    // 임시 웹사이트용
    @GetMapping("/fragments/widget/widget.do")
    public String showWidgetPage() {
        return "/fragments/widget/widget";
    }
}
