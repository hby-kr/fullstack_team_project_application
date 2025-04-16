package com.artu.fullstack_team_project_application.entity.widgets;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@IdClass(WidgetDetailId.class)
@Table(name = "widget_details")
@Getter @Setter
public class WidgetDetail {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "widget_id")
    private Widget widget;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "widget_json")
    private Map<String, Object> widgetJson;

    @Column(name = "widget_content")
    private String widgetContent;

    @Column(name = "widget_order")
    private Integer widgetOrder = 0;
}
