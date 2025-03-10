package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetailId;
import com.artu.fullstack_team_project_application.service.widgets.WidgetDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/widget-details")
public class WidgetDetailController {

    private final WidgetDetailService widgetDetailService;

    @Autowired
    public WidgetDetailController(WidgetDetailService widgetDetailService) {
        this.widgetDetailService = widgetDetailService;
    }
}