package com.artu.fullstack_team_project_application.service.users;

import com.artu.fullstack_team_project_application.entity.users.user.UserSetting;

import java.util.Optional;

public interface UserSettingService {
    public void save(UserSetting userSetting);
    public void delete(UserSetting userSetting);

    // 설정 확인
    public Optional<UserSetting> findOne(String userId);
}
