package com.artu.fullstack_team_project_application.service.users;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.users.user.UserloginLogs;
import org.springframework.stereotype.Service;

public interface UserLoginLogService {

    public UserloginLogs save(UserloginLogs userloginLogs);
}
