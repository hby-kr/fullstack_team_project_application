package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetDetailRepository;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WidgetDetailService {

    private final WidgetDetailRepository widgetDetailRepository;
    private final WidgetRepository widgetRepository; // 추가

    @Autowired
    public WidgetDetailService(WidgetDetailRepository widgetDetailRepository,
                               WidgetRepository widgetRepository) {
        this.widgetDetailRepository = widgetDetailRepository;
        this.widgetRepository = widgetRepository;
    }

    public List<Map<String, Object>> getUserWidgets(String userId) {
        List<WidgetDetail> details = widgetDetailRepository.findByUserIdOrdered(userId);
        List<Map<String, Object>> result = new ArrayList<>();
        for (WidgetDetail detail : details) {
            Map<String, Object> map = new HashMap<>();
            map.put("widget_id", detail.getWidget().getId());
            map.put("widget_size", detail.getWidget().getWidgetSize());
            map.put("widget_theme", detail.getWidget().getWidgetTheme());
            map.put("widget_json", detail.getWidgetJson());
            map.put("widget_content", detail.getWidgetContent());
            map.put("widget_order", detail.getWidgetOrder());
            result.add(map);
        }
        return result;
    }

    public void updateWidgetOrder(String userId, Integer widgetId, Integer order) {
        widgetDetailRepository.updateWidgetOrder(userId, widgetId, order);
    }

    public void deleteWidget(String userId, Integer widgetId) {
        widgetDetailRepository.deleteByUserIdAndWidgetId(userId, widgetId);
    }

    public Map<String, Object> getWidgetJsonByUserIdAndWidgetId(String userId, Integer widgetId) {
        return widgetDetailRepository.findWidgetJsonByUserIdAndWidgetId(userId, widgetId);
    }

    public void addWidgetToUser(String userId, Integer widgetId) {
        WidgetDetail detail = new WidgetDetail();
        detail.setUser(new User() {{ setUserId(userId); }});
        detail.setWidget(new Widget() {{ setId(widgetId); }});
        detail.setWidgetJson(Map.of("type", "unknown", "label", "새 위젯")); // 필요시 수정
        detail.setWidgetContent("");
        detail.setWidgetOrder(99); // 기본 order

        widgetDetailRepository.save(detail);
    }

    public List<Map<String, Object>> getAllWidgets() {
        List<Widget> widgets = widgetRepository.findAll();

        List<Map<String, Object>> result = new ArrayList<>();
        for (Widget widget : widgets) {
            Map<String, Object> map = new HashMap<>();
            map.put("widget_id", widget.getId());
            map.put("widget_size", widget.getWidgetSize());
            map.put("widget_theme", widget.getWidgetTheme());

            // 세부 정보도 포함 (선택)
            Map<String, Object> detail = widgetDetailRepository.findFirstByWidgetId(widget.getId());
            if (detail != null) {
                map.put("widget_json", detail.get("widget_json"));
            }

            result.add(map);
        }

        return result;
    }

}
