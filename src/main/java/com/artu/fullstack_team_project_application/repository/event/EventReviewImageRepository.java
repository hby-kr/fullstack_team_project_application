package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventReviewImageRepository extends JpaRepository<EventReviewImage, Integer> {
    List<EventReviewImage> findByUser_UserId(String userId);
}
