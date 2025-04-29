package com.artu.fullstack_team_project_application.dto.users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private String nickname;
    // 필요한거 더 넣기로.
}
