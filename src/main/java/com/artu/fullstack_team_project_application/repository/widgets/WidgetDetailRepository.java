package com.artu.fullstack_team_project_application.repository.widgets;

import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WidgetDetailRepository extends JpaRepository<WidgetDetail, WidgetDetailId> {
    @Query("SELECT wd FROM WidgetDetail wd WHERE wd.user.userId = :userId ORDER BY wd.widgetOrder ASC")
    List<WidgetDetail> findAllByUserIdOrderByOrder(@Param("userId") String userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM WidgetDetail wd WHERE wd.user.userId = :userId AND wd.widget.id = :widgetId")
    void deleteByUserIdAndWidgetId(@Param("userId") String userId, @Param("widgetId") Integer widgetId);
}


