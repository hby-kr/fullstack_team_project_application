package com.artu.fullstack_team_project_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.artu.fullstack_team_project_application.service.widgets.WidgetDetailService;
import com.artu.fullstack_team_project_application.service.widgets.WidgetService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

@SpringBootTest
class WidgetControllerTest {

    @Autowired
    WidgetService widgetService;

    @Autowired
    WidgetDetailService widgetDetailService;

    @Test
    void getAllWidgets() {
        List<Map<String, Object>> widgets = widgetService.getAllWidgets();
        System.out.println("[전체 위젯 목록]");
        widgets.forEach(System.out::println);
    }

    @Test
    void getUserWidgets() {
        String userId = "user1001";
        List<Map<String, Object>> userWidgets = widgetDetailService.getUserWidgets(userId);
        System.out.println("[사용자 위젯 목록] userId = " + userId);
        userWidgets.forEach(System.out::println);
    }
}
