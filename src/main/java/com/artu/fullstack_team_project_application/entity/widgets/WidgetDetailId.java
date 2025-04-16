package com.artu.fullstack_team_project_application.entity.widgets;

import java.io.Serializable;
import java.util.Objects;

public class WidgetDetailId implements Serializable {

    private String user;      // User 엔티티의 @Id 필드 타입과 이름에 맞게!
    private Integer widget;   // Widget 엔티티의 @Id 필드 타입과 이름에 맞게!

    public WidgetDetailId() {}

    public WidgetDetailId(String user, Integer widget) {
        this.user = user;
        this.widget = widget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WidgetDetailId)) return false;
        WidgetDetailId that = (WidgetDetailId) o;
        return Objects.equals(user, that.user) && Objects.equals(widget, that.widget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, widget);
    }
}
