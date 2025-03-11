package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.repository.widgets.WidgetDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WidgetDetailService {

    private final WidgetDetailRepository widgetDetailRepository;

    @Autowired
    public WidgetDetailService(WidgetDetailRepository widgetDetailRepository) {
        this.widgetDetailRepository = widgetDetailRepository;
    }

    public Map<String, Object> getWidgetJsonByUserIdAndWidgetId(String userId, Integer widgetId) {
        return widgetDetailRepository.findWidgetJsonByUserIdAndWidgetId(userId, widgetId);
    }

    public Integer findWidgetIdByInfoName(String infoName) {
        return widgetDetailRepository.findWidgetIdByInfoName(infoName);
    }
}