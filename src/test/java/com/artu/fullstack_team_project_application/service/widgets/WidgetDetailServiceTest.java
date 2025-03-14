package com.artu.fullstack_team_project_application.service.widgets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class WidgetDetailServiceTest {

    @Autowired
    private WidgetDetailService widgetDetailService;

    @Test
    void testGetWidgetJsonByUserIdAndWidgetId() {
        Map<String, Object> widgetJson = widgetDetailService.getWidgetJsonByUserIdAndWidgetId("user1", 1);

        assertNotNull(widgetJson);
        System.out.println("Widget JSON: " + widgetJson);
    }

    @Test
    void findWidgetIdByInfoName() {
        Integer widgetId = widgetDetailService.findWidgetIdByInfoName("Calendar Info");
        System.out.println("Found widget_id: " + widgetId);
    }

}