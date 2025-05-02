package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import com.artu.fullstack_team_project_application.service.widgets.WidgetDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/widget-details")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class WidgetDetailController {

    private final WidgetDetailService widgetDetailService;

    @Autowired
    public WidgetDetailController(WidgetDetailService widgetDetailService) {
        this.widgetDetailService = widgetDetailService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addWidgetDetail(@RequestBody Map<String, Object> body) {
        String userId = (String) body.get("user_id");
        Integer widgetId = (Integer) body.get("widget_id");
        String content = (String) body.getOrDefault("widget_content", "");

        widgetDetailService.addWidgetDetail(userId, widgetId, content);
        return ResponseEntity.ok().build();
    }
}