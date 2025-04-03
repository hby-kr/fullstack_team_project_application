package com.artu.fullstack_team_project_application.service.users;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.users.user.UserloginLogs;
import com.artu.fullstack_team_project_application.repository.users.UserLoginLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginLogServiceImp implements UserLoginLogService {

    @Autowired
    private UserLoginLogRepository userLoginLogRepository;


    @Override
    public UserloginLogs save(UserloginLogs userloginLogs) {
        return userLoginLogRepository.save(userloginLogs);
    }
}
