package com.artu.fullstack_team_project_application.dto;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class UserPageDto {
    private User user;
    private Long countFollowee;
    private Long countFollower;
    private Long countPosting;
    private Long countLike;
}
