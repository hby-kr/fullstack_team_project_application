package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.service.widgets.WidgetDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/widget-details")
public class WidgetDetailController {

    private final WidgetDetailService widgetDetailService;

    @Autowired
    public WidgetDetailController(WidgetDetailService widgetDetailService) {
        this.widgetDetailService = widgetDetailService;
    }

    @PutMapping("/{widgetId}/used")
    public String markWidgetAsUsed(@PathVariable Integer widgetId, @RequestParam String userId) {
        boolean isUpdated = widgetDetailService.getWidgetJsonByUserIdAndWidgetId(userId, widgetId).isEmpty();
        if (isUpdated) {
            return ResponseEntity.ok("위젯 등록 성공").toString();
        } else {
            return ResponseEntity.badRequest().toString();
        }
    }

    @PutMapping("/{widgetId}/unused")
    public String markWidgetAsUnused(@PathVariable Integer widgetId, @RequestParam String userId) {
        boolean isUpdated = widgetDetailService.getWidgetJsonByUserIdAndWidgetId(userId, widgetId).isEmpty();
        if (isUpdated) {
            return ResponseEntity.ok("위젯 비등록 성공").toString();
        }else {
            return ResponseEntity.badRequest().toString();
        }
    }
}