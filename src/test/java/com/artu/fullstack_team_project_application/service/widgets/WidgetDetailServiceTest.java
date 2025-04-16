package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetailId;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetDetailRepository;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WidgetDetailServiceTest {

    @Autowired
    private WidgetRepository widgetRepository;

    @Autowired
    private WidgetDetailRepository widgetDetailRepository;

    @Autowired
    private WidgetDetailService widgetDetailService;

    @Test
    void findUserWidgetsOrderedTest() {
        List<Map<String, Object>> widgets = widgetDetailService.getUserWidgets("user1001");
        assertFalse(widgets.isEmpty());
        widgets.forEach(System.out::println);
    }

    @Test
    void updateWidgetOrderTest() {
        widgetDetailService.updateWidgetOrder("user1001", 1, 99);
        List<Map<String, Object>> widgets = widgetDetailService.getUserWidgets("user1001");
        assertEquals(99, widgets.stream()
                .filter(w -> (Integer) w.get("widget_id") == 1)
                .findFirst().orElseThrow().get("widget_order"));
    }

    @Test
    void deleteWidgetTest() {
        // 임시 widget_detail 생성
        Optional<Widget> widget = widgetRepository.findById(999);
        if (widget.isEmpty()) {
            widgetRepository.save(new Widget() {{
                setId(999);
                setWidgetSize(1);
                setWidgetTheme("Test");
            }});
        }

        WidgetDetail wd = new WidgetDetail();
        wd.setUser(new User() {{ setUserId("user1001"); }});
        wd.setWidget(widgetRepository.getReferenceById(999));
        wd.setWidgetOrder(77);
        wd.setWidgetJson(Map.of("type", "memo", "label", "테스트"));
        wd.setWidgetContent("Test");

        widgetDetailRepository.save(wd);
        widgetDetailService.deleteWidget("user1001", 999);
        assertTrue(widgetDetailRepository.findById(new WidgetDetailId("user1001", 999)).isEmpty());
    }
}
