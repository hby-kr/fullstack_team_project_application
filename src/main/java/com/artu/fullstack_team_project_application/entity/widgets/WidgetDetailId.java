package com.artu.fullstack_team_project_application.entity.widgets;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class WidgetDetailId implements Serializable {

    private String user;
    private Integer widget;

    public WidgetDetailId() {}

    public WidgetDetailId(String user, Integer widget) {
        this.user = user;
        this.widget = widget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WidgetDetailId that)) return false;
        return Objects.equals(user, that.user) && Objects.equals(widget, that.widget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, widget);
    }
}
