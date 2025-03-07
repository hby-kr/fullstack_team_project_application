package com.artu.fullstack_team_project_application.entity.events.event;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
public class UserEventLikeId implements java.io.Serializable {
    private static final long serialVersionUID = 6123951852871493484L;
}