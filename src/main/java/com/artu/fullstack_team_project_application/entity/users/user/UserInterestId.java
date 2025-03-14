package com.artu.fullstack_team_project_application.entity.users.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
public class UserInterestId implements java.io.Serializable {
    private static final long serialVersionUID = -5916840104079145592L;

    @Column (name = "user_id", nullable = false)
    private String userId;

    @Column (name = "ctgr_id", nullable = false)
    private int ctgrId;
}