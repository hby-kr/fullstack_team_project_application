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
}
