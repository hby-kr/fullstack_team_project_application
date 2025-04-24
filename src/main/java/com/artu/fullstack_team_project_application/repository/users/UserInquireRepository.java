package com.artu.fullstack_team_project_application.repository.users;

import com.artu.fullstack_team_project_application.entity.users.base.UserInquire;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserInquireRepository extends JpaRepository<UserInquire, Integer> {

    @EntityGraph(attributePaths = "user")
    List<UserInquire> findAll();

    @EntityGraph(attributePaths = "user")
    Set<UserInquire> findByUser_UserId(String userId);

    @EntityGraph(attributePaths = "user")
    Optional<UserInquire> findOneByInquireIdAndUser_UserId(Integer inquireId, String userId);

    @EntityGraph(attributePaths = "user")
    Optional<UserInquire> findOneByUser_UserId(String userId);

    @EntityGraph(attributePaths = "user")
    Set<UserInquire> findByInquireCategory(UserInquire.InquireCategory inquireCategory);

}
