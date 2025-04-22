package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventReviewRepository extends JpaRepository<EventReview, Integer> {

    @EntityGraph(attributePaths = "eventReviewImages")
    List<EventReview> findByEventId(int eventId);

}
