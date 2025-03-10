package com.artu.fullstack_team_project_application.entity.widgets;

import jakarta.persistence.Embeddable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class WidgetDetailId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = -6033021146560116394L;
}