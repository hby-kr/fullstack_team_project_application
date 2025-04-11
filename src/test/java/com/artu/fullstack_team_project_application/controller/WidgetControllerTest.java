package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.service.widgets.WidgetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WidgetControllerTest {

    @Autowired
    private WidgetService widgetService;


    @Test
    void markWidgetAsUsed() {
    }

    @Test
    void markWidgetAsUnused() {
    }

    @Test
    void getWidgetIdsByTheme() {
    }

    @Test
    void getWidgetTheme() {
    }

    @Test
    void getWidgetSize() {
    }

    @Test
    void getAllWidgetsWithDetails() {
        List<Map<String, Object>> result = widgetService.getAllWidgetsWithDetails();
        System.out.println("위젯 데이터: " + result);

        // 테스트로 결과가 null이 아님을 확인
        assert result != null;
    }

    @Test
    void testToString() {
    }
}