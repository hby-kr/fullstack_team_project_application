package com.artu.fullstack_team_project_application.service.event;


import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;

import java.util.List;
import java.util.Optional;

public interface EventReviewImageService {
    List<EventReviewImage> getImagesByEventId(Integer eventId);
    List<EventReviewImage> getImagesByUserId(String userId);
    Optional<EventReviewImage> getImageById(Integer imageId);
    EventReviewImage saveImage(EventReviewImage eventReviewImage);
    void deleteImage(Integer imageId);
}
