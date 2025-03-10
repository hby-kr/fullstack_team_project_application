package com.artu.fullstack_team_project_application.entity.widgets;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "widget_details")
public class WidgetDetail {
    @EmbeddedId
    private WidgetDetailId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "widget_id", nullable = false)
    private Widget widgetId;

    @Column(name = "info_name", nullable = false, length = 50)
    private String infoName;

    @Column(name = "widget_json")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> widgetJson;

}