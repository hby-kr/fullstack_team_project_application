package com.artu.fullstack_team_project_application.repository.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WidgetRepository extends JpaRepository<Widget, Integer> {
}
