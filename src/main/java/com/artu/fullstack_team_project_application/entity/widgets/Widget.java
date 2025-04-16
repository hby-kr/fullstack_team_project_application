package com.artu.fullstack_team_project_application.entity.widgets;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name = "widgets")
@Getter @Setter
public class Widget {
    @Id
    @Column(name = "widget_id")
    private Integer id;

    @Column(name = "widget_size", nullable = false)
    private Integer widgetSize;

    @Column(name = "widget_theme", nullable = false)
    private String widgetTheme;
}
