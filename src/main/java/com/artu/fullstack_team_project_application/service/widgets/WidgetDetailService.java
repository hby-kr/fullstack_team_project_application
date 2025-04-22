package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetailId;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WidgetDetailService {

    private final WidgetDetailRepository widgetDetailRepository;

    @Autowired
    public WidgetDetailService(WidgetDetailRepository widgetDetailRepository) {
        this.widgetDetailRepository = widgetDetailRepository;
    }

    public List<Map<String, Object>> getUserWidgets(String userId) {
        return widgetDetailRepository.findAllByUserIdOrderByOrder(userId).stream().map(wd -> {
            Widget w = wd.getWidget();
            Map<String, Object> m = new HashMap<>();
            m.put("widget_id", w.getId());
            m.put("widget_size", w.getWidgetSize());
            m.put("widget_theme", w.getWidgetTheme());
            m.put("widget_json", w.getWidgetJson());
            return m;
        }).collect(Collectors.toList());
    }

    public void deleteWidget(String userId, Integer widgetId) {
        widgetDetailRepository.deleteByUserIdAndWidgetId(userId, widgetId);
    }

    public void updateWidgetOrder(List<Map<String, Object>> orders) {
        orders.forEach(entry -> {
            String userId = (String) entry.get("user_id");
            Integer widgetId = (Integer) entry.get("widget_id");
            Integer order = (Integer) entry.get("order");

            WidgetDetailId id = new WidgetDetailId(userId, widgetId);
            widgetDetailRepository.findById(id).ifPresent(wd -> {
                wd.setWidgetOrder(order);
                widgetDetailRepository.save(wd);
            });
        });
    }
}


