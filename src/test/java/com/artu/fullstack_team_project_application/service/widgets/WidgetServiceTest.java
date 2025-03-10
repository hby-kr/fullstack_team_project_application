package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WidgetServiceTest {

    @Autowired
    private WidgetService widgetService;

    @Autowired
    private WidgetRepository widgetRepository;


    @Test
    void findWidgetById() {
        // Assuming widget with ID = 1 exists in the database
        Widget widget = widgetService.findWidgetById(1);
        System.out.println("Find Widget by ID: " + widget);
    }

    @Test
    void findWidgetsByUserIdAndUsed() {
        // Assuming userId "user1" exists and has widgets with widgetIsUsed = true
        List<Widget> widgets = widgetService.findWidgetsByUserIdAndUsed("user1");
        System.out.println("Widgets: " + widgets);

        if (!widgets.isEmpty()) {
            Widget firstWidget = widgets.get(0);
            System.out.println("First Widget: " + firstWidget);
        }
    }

    @Test
    void setWidgetUsedTrue() {
        // Assuming widget with ID = 1 exists and belongs to user "user1"
        boolean isUpdated = widgetService.setWidgetUsedTrue(1, "user1");
        System.out.println("Set Widget Used True: " + isUpdated);
    }

    @Test
    void setWidgetUsedFalse() {
        // Assuming widget with ID = 1 exists and belongs to user "user1"
        boolean isUpdated = widgetService.setWidgetUsedFalse(1, "user1");
        System.out.println("Set Widget Used False: " + isUpdated);
    }

    @Test
    void getWidgetIdsByTheme() {
        // Assuming there are widgets in the database with the theme "Light"
        List<Integer> widgetIds = widgetService.getWidgetIdsByTheme("Light");
        System.out.println("Widgets with theme 'Light': " + widgetIds);
    }


    @Test
    void testFindWidgetsByUserIdAndUsed() {
    }
}