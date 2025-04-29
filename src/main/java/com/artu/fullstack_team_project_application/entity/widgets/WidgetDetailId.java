package com.artu.fullstack_team_project_application.entity.widgets;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable   // 🔥 꼭 필요함!
@EqualsAndHashCode
public class WidgetDetailId implements Serializable {

    private String userId;    // 필드명 변경
    private Integer widgetId; // 필드명 변경

    public WidgetDetailId() {}

    public WidgetDetailId(String userId, Integer widgetId) {
        this.userId = userId;
        this.widgetId = widgetId;
    }
}
