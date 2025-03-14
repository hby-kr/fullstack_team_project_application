package com.artu.fullstack_team_project_application.repository.postings;

import com.artu.fullstack_team_project_application.entity.postings.UserFollow;
import com.artu.fullstack_team_project_application.entity.postings.UserFollowId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFollowRepository extends JpaRepository<UserFollow, UserFollowId> {
    // follow 리스트
    @Query("SELECT uf.followerId, u.userName, u.userEmail FROM UserFollow uf " +
            "LEFT JOIN User u ON uf.followeeId = u.userId " +
            "WHERE uf.followeeId = :userId")
    List<UserFollow> findByFollowerId(@Param("followerId") String followerId);

    @Query("SELECT uf.followerId, u.userName, u.userEmail FROM UserFollow uf " +
            "LEFT JOIN User u ON uf.followeeId = u.userId " +
            "WHERE uf.followeeId = :userId")
    List<UserFollow> findByFolloweeId(@Param("followeeId") String followeeId);

    // follow 수
    @Query("SELECT COUNT(uf.followeeId) " +
            "FROM User u LEFT JOIN UserFollow uf " +
            "ON u.userId = uf.followerId " +
            "WHERE u.userId = :followerId " +
            "GROUP BY u.userId")
    Long countFolloweeByUserId(@Param("followerId") String followerId);

    @Query("SELECT COUNT(uf.followerId) " +
            "FROM User u LEFT JOIN UserFollow uf " +
            "ON u.userId = uf.followeeId " +
            "WHERE u.userId = :followeeId " +
            "GROUP BY u.userId")
    Long countFollowerByUserId(@Param("followeeId") String followeeId);
}
