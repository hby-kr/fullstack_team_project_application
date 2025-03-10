package com.artu.fullstack_team_project_application.repository.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetDetailRepository extends JpaRepository<WidgetDetail, WidgetDetailId> {

}
