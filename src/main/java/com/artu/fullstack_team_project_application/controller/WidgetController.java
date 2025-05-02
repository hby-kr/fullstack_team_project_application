package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.service.widgets.WidgetDetailService;
import com.artu.fullstack_team_project_application.service.widgets.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/widgets")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class WidgetController {

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