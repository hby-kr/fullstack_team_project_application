package com.artu.fullstack_team_project_application.service.widgets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetDetailService {
    private final WidgetService widgetService;

    @Autowired
    public WidgetDetailService(WidgetService widgetService) {
        this.widgetService = widgetService;
    }

    public WidgetService getWidgetService() {
        return widgetService;
    }
}
