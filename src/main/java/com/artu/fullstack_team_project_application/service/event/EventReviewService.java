package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;

import java.util.List;
import java.util.Optional;

public interface EventReviewService {
    List<EventReview> getAllEventReviews();
    List<EventReview> getReviewsByEventId(Integer eventId);
    List<EventReview> getReviewsByUserId(String userId);
    Optional<EventReview> getReviewById(Integer reviewId);
    EventReview createReview(EventReview eventReview);
    EventReview updateReview(Integer reviewId, String content, Integer rate);
    void deleteReview(Integer reviewId);
}
