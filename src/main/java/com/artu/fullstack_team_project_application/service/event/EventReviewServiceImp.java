package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.repository.event.EventReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventReviewServiceImp implements EventReviewService {
    private final EventReviewRepository eventReviewRepository;
    public EventReviewServiceImp(EventReviewRepository eventReviewRepository) {
        this.eventReviewRepository = eventReviewRepository;
    }

    @Override
    public List<EventReview> getReviewsByEventId(Integer eventId) {
        return eventReviewRepository.findByEventId(eventId);
    }

    @Override
    public List<EventReview> getReviewsByUserId(String userId) {
        return eventReviewRepository.findByUser_UserId(userId);
    }

    @Override
    public Optional<EventReview> getReviewById(Integer reviewId) {
        return Optional.empty();
    }

    @Override
    public EventReview createReview(EventReview eventReview) {
        return null;
    }

    @Override
    public EventReview updateReview(Integer reviewId, String content, Integer rate) {
        return null;
    }

    @Override
    public void deleteReview(Integer reviewId) {

    }
}