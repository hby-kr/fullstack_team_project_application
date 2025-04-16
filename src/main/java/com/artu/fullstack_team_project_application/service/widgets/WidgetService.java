package com.artu.fullstack_team_project_application.service.widgets;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.repository.widgets.WidgetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

    private final WidgetRepository widgetRepository;

    @Autowired
    public WidgetService(WidgetRepository widgetRepository) {
        this.widgetRepository = widgetRepository;
    }

    public List<Widget> findAllWidgets() {
        return widgetRepository.findAll();
    }
}
