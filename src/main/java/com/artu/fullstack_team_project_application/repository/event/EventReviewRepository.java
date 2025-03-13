package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventReviewRepository extends JpaRepository<EventReview, Integer> {
    List<EventReview> findByEventId(Integer eventId);
    List<EventReview> findByUser_UserId(String userId);
}
