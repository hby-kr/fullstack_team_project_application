package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetailId;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetDetailService {
    private final WidgetDetailRepository widgetDetailRepository;

    @Autowired
    public WidgetDetailService(WidgetDetailRepository widgetDetailRepository) {
        this.widgetDetailRepository = widgetDetailRepository;
    }


}
