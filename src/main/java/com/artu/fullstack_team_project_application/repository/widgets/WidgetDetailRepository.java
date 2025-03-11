package com.artu.fullstack_team_project_application.repository.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface WidgetDetailRepository extends JpaRepository<WidgetDetail, Integer> {

    @Query("SELECT wd.widgetJson FROM WidgetDetail wd WHERE wd.user.userId = :userId AND wd.widgetId.id = :widgetId")
    Map<String, Object> findWidgetJsonByUserIdAndWidgetId(@Param("userId") String userId, @Param("widgetId") Integer widgetId);

    @Query("SELECT wd.widgetId.id FROM WidgetDetail wd WHERE wd.infoName = :infoName")
    Integer findWidgetIdByInfoName(@Param("infoName") String infoName);

}