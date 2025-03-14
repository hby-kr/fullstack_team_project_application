package com.artu.fullstack_team_project_application.service.users;

import com.artu.fullstack_team_project_application.entity.postings.UserFollow;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.users.user.UserInterest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {


    // 관리자 페이지, 회원 검색
    public Page<User> readAll(Pageable pageable);

    //
    public Optional<User> readOne(String userId);

    public User save(User user);

    public void delete(String userId);

    public List<UserInterest> readInterests(String userId);
    public List<UserInterest> saveInterests(UserInterest userInterest);

    // follow
    public List<UserFollow> findByFolloweeId(String followeeId);
    public List<UserFollow> findByFollowerId(String followerId);




}
