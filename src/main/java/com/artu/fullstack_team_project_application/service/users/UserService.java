package com.artu.fullstack_team_project_application.service.users;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.users.user.UserInterest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Page<User> readAll(Pageable pageable);

    public Optional<User> readOne(String userId);

    public void save(User user);

    public void delete(String userId);

    public List<UserInterest> readInterests(String userId);
    public List<UserInterest> saveInterests(UserInterest userInterest);


}
