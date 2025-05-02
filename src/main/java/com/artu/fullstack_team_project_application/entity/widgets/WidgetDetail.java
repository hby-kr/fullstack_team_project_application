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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "widget_detail_id")  // ✅ 여기 column명 명시
    private Integer widgetDetailId;      // ✅ id 필드 이름도 widgetDetailId로 정확히

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "widget_id")
    private Widget widget;

    @Column(name = "widget_content")
    private String widgetContent;

    @Column(name = "widget_order")
    private Integer widgetOrder;
}

