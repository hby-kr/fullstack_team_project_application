package com.artu.fullstack_team_project_application.dto.users;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter@Setter@ToString
public class LoginRequestDto {

    @NotBlank
    private String id;
    @NotBlank
    private String pw;

}
