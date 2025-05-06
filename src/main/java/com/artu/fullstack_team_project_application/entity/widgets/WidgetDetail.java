package com.artu.fullstack_team_project_application.entity.widgets;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name = "widget_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WidgetDetail {

    @EmbeddedId
    private WidgetDetailId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")  // 복합키의 userId 필드에 매핑
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("widgetId") // 복합키의 widgetId 필드에 매핑
    @JoinColumn(name = "widget_id")
    private Widget widget;

    @Column(name = "widget_content")
    private String widgetContent;

    @Column(name = "widget_order")
    private Integer widgetOrder;
}
