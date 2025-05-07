package com.artu.fullstack_team_project_application.dto.users;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OAuthUser {

    @NotBlank
    private String email;

    private String name;

    private String picture;

    @NotBlank
    private String oauth;

}