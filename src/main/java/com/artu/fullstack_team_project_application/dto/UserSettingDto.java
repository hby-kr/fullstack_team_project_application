package com.artu.fullstack_team_project_application.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserSettingDto {
    private Integer settingId;
    private String userId;
    private String userName;
    private String userEmail;
    private String displayColor ;
    private String language;
    private Instant setAt;
}
