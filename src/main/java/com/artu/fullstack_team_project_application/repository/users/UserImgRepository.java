package com.artu.fullstack_team_project_application.repository.users;

import com.artu.fullstack_team_project_application.entity.users.user.UserImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserImgRepository extends JpaRepository<UserImg, Integer> {
    Set<UserImg> findUserImgByUser_UserId(String userId);

}
