package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WidgetServiceTest {

    @Test
    void createWidgetTest() {
        User user = new User();
        user.setUserId("user1");

        // 새 Widget 생성 테스트
        Widget widget = widgetService.createWidget(100, user, 2, "Dark");
        assertNotNull(widget);
        assertEquals(100, widget.getId());
        assertEquals("Dark", widget.getWidgetTheme());
        assertEquals(2, widget.getWidgetSize());
        assertEquals("user1", widget.getUser().getUserId());
    }

    @Test
    void deleteWidgetByIdTest() {
        // 위젯 삭제 테스트 (위젯 ID가 데이터베이스에 존재한다고 가정)
        Integer widgetId = 100;

        // 위젯 삭제 시 예외가 발생하지 않아야 함
        assertDoesNotThrow(() -> widgetService.deleteWidgetById(widgetId));

        // 삭제 후 존재 여부 검증
        assertThrows(IllegalArgumentException.class, () -> widgetService.deleteWidgetById(widgetId));
    }


    @Autowired
    private WidgetService widgetService;

    @Test
    void findWidgetById() {
        Widget widget = widgetService.findWidgetById(1);
        System.out.println("Find Widget by ID: " + widget);
    }

    @Test
    void findWidgetsByUserIdAndUsed() {
        List<Widget> widgets = widgetService.findWidgetsByUserIdAndUsed("user1");
        System.out.println("Widgets: " + widgets);
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
    void findWidgetThemeByWidgetIdAndUserId() {
        String widgetTheme = widgetService.findWidgetThemeByWidgetIdAndUserId(1, "user1");
        System.out.println("Widget Theme: " + widgetTheme);
    }

    @Test
    void findWidgetSizeByWidgetIdAndUserId() {
        Integer widgetSize = widgetService.findWidgetSizeByWidgetIdAndUserId(1, "user1");
        System.out.println("Widget Size: " + widgetSize);
    }

    @Test
    void findWidgetIdByWidgetSizeAndUserId() {
        Integer widgetId = widgetService.findWidgetIdByWidgetSizeAndUserId(1, "user1");
        System.out.println("Found WidgetId: " + widgetId);
    }
}