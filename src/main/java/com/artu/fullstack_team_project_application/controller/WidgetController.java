package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.service.widgets.WidgetDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/widgets")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class WidgetController {

    private final WidgetDetailService widgetDetailService;

    @Autowired
    public WidgetController(WidgetDetailService widgetDetailService) {
        this.widgetDetailService = widgetDetailService;
    }

    // 사용자별 위젯 조회
    @GetMapping("/used")
    public ResponseEntity<List<Map<String, Object>>> getUsedWidgetsByUserId(@RequestParam String userId) {
        List<Map<String, Object>> results = widgetDetailService.getUserWidgets(userId);
        return ResponseEntity.ok(results);
    }

    // 위젯 삭제
    @DeleteMapping("/delete/{widgetId}")
    public ResponseEntity<String> deleteWidget(@PathVariable Integer widgetId, @RequestParam String userId) {
        try {
            widgetDetailService.deleteWidget(userId, widgetId);
            return ResponseEntity.ok("삭제 완료");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("삭제 실패: " + e.getMessage());
        }
    }

    // 위젯 순서 업데이트
    @PostMapping("/order")
    public ResponseEntity<String> updateWidgetOrder(@RequestBody List<Map<String, Object>> widgetOrders) {
        for (Map<String, Object> entry : widgetOrders) {
            Integer widgetId = (Integer) entry.get("widget_id");
            String userId = (String) entry.get("user_id");
            Integer order = (Integer) entry.get("order");
            widgetDetailService.updateWidgetOrder(userId, widgetId, order);
        }
        return ResponseEntity.ok("위젯 순서 저장 완료");
    }

    // 위젯 추가
    @PostMapping("/add")
    public ResponseEntity<String> addWidgetToUser(@RequestBody Map<String, Object> payload) {
        try {
            String userId = (String) payload.get("user_id");
            Integer widgetId = (Integer) payload.get("widget_id");
            widgetDetailService.addWidgetToUser(userId, widgetId);
            return ResponseEntity.ok("위젯 추가 완료");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("위젯 추가 실패: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Map<String, Object>>> getAllWidgets() {
        List<Map<String, Object>> widgets = widgetDetailService.getAllWidgets();
        return ResponseEntity.ok(widgets);
    }
}
