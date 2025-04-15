package com.artu.fullstack_team_project_application.entity.widgets;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "widgets")
public class Widget {
    @Id
    @Column(name = "widget_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "widget_size", nullable = false)
    private Integer widgetSize;

    @Column(name = "widget_is_used", nullable = false)
    private Boolean widgetIsUsed;

    @ColumnDefault("'Light'")
    @Column(name = "widget_theme", nullable = false)
    private String widgetTheme = "Light";
}