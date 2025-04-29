package com.artu.fullstack_team_project_application.dto.users;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseAuthDto {

    private String jwt;
    private User user;
}
