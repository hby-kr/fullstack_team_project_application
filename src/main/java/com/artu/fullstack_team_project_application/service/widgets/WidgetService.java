package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WidgetService {
    private final WidgetRepository widgetRepository;

    @Autowired
    public WidgetService(WidgetRepository widgetRepository) {
        this.widgetRepository = widgetRepository;
    }

    public List<Map<String, Object>> getAllWidgets() {
        return widgetRepository.findAll().stream().map(w -> {
            Map<String, Object> m = new HashMap<>();
            m.put("widget_id", w.getId());
            m.put("widget_size", w.getWidgetSize());
            m.put("widget_theme", w.getWidgetTheme());
            m.put("widget_json", w.getWidgetJson());
            return m;
        }).collect(Collectors.toList());
    }
}

