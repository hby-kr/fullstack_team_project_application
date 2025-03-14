package com.artu.fullstack_team_project_application.entity.postings;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class UserFollowId implements java.io.Serializable {
    private static final long serialVersionUID = -4195320815653977628L;

    @Column(name = "follower_id", nullable = false)
    private String followerId;

    @Column(name = "followee_id", nullable = false)
    private String followeeId;

    // 기본 생성자
    public UserFollowId() {}
}