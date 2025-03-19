package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import com.artu.fullstack_team_project_application.repository.event.EventReviewImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class EventReviewImageServiceImp implements EventReviewImageService {
    private final EventReviewImageRepository eventReviewImageRepository;
    public EventReviewImageServiceImp(EventReviewImageRepository eventReviewImageRepository) {
        this.eventReviewImageRepository = eventReviewImageRepository;
    }

    @Override
    public List<EventReviewImage> getImagesByEventId(Integer eventId) {
        return eventReviewImageRepository.findByEventId(eventId);
    }

    @Override
    public List<EventReviewImage> getImagesByUserId(String userId) {
        return eventReviewImageRepository.findByUser_UserId(userId);
    }

    @Override
    public Optional<EventReviewImage> getImageById(Integer imageId) {
        return eventReviewImageRepository.findById(imageId);
    }

    @Override
    @Transactional
    public EventReviewImage saveImage(EventReviewImage eventReviewImage) {
        eventReviewImage.setCreateAt(Instant.now());
        return eventReviewImageRepository.save(eventReviewImage);
    }

    @Override
    @Transactional
    public void deleteImage(Integer imageId) {
        eventReviewImageRepository.deleteById(imageId);
    }
}
