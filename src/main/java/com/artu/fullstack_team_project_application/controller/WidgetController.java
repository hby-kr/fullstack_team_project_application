package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.service.widgets.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/widgets")
public class WidgetController {

    private final WidgetService widgetService;

    @Autowired
    public WidgetController(WidgetService widgetService) {
        this.widgetService = widgetService;
    }

    @PutMapping("/{widgetId}/used")
    public ResponseEntity<String> markWidgetAsUsed(@PathVariable Integer widgetId, @RequestParam String userId) {
        boolean isUpdated = widgetService.setWidgetUsedTrue(widgetId, userId);
        if (isUpdated) {
            return ResponseEntity.ok("위젯 등록 성공");
        } else {
            return ResponseEntity.badRequest().body("위젯 등록 실패");
        }
    }

    @PutMapping("/{widgetId}/unused")
    public ResponseEntity<String> markWidgetAsUnused(@PathVariable Integer widgetId, @RequestParam String userId) {
        boolean isUpdated = widgetService.setWidgetUsedFalse(widgetId, userId);
        if (isUpdated) {
            return ResponseEntity.ok("위젯 비등록 성공");
        } else {
            return ResponseEntity.badRequest().body("위젯 비등록 실패");
        }
    }

    @GetMapping("/by-theme")
    public ResponseEntity<List<Integer>> getWidgetIdsByTheme(@RequestParam String theme) {
        List<Integer> widgetIds = widgetService.getWidgetIdsByTheme(theme);
        return ResponseEntity.ok(widgetIds);
    }

    @GetMapping("/{widgetId}/theme")
    public ResponseEntity<String> getWidgetTheme(@PathVariable Integer widgetId, @RequestParam String userId) {
        try {
            String widgetTheme = widgetService.findWidgetThemeByWidgetIdAndUserId(widgetId, userId);
            return ResponseEntity.ok(widgetTheme);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{widgetId}/size")
    public ResponseEntity<Integer> getWidgetSize(@PathVariable Integer widgetId, @RequestParam String userId) {
        try {
            Integer widgetSize = widgetService.findWidgetSizeByWidgetIdAndUserId(widgetId, userId);
            return ResponseEntity.ok(widgetSize);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}