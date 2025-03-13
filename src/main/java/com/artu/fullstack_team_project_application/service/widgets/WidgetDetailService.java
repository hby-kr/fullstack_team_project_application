package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    public Map<String, Object> getDetailsForWidget(Integer widgetId) {
        Map<String, Object> detailsMap = new HashMap<>();
        List<WidgetDetail> widgetDetails = widgetDetailRepository.findByWidgetId(widgetId);

        for (WidgetDetail detail : widgetDetails) {
            detailsMap.put("info_name", detail.getInfoName());
            detailsMap.put("widget_json", detail.getWidgetJson());
        }

        return detailsMap;
    }
}