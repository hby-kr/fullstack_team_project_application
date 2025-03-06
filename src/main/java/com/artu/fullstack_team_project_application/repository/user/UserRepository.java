package com.artu.fullstack_team_project_application.repository.user;

import com.artu.fullstack_team_project_application.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
