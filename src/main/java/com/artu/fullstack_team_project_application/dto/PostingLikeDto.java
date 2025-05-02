package com.artu.fullstack_team_project_application.dto;

import com.artu.fullstack_team_project_application.entity.postings.Posting;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@ToString
public class PostingLikeDto {
    private String userId;
    private String postId;
    private User user;
    private Posting posting;
    private Instant likedAt;
    private Boolean isUsed;
}
