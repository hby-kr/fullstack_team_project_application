package com.artu.fullstack_team_project_application.service.event;


import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;

import java.util.List;
import java.util.Optional;

public interface EventReviewImageService {
    List<EventReviewImage> getImagesByEventId(Integer eventId); //공연의 모든 리뷰이미지 조회
//    List<EventReviewImage> getImagesByUserId(String userId); //유저가 올린 리뷰이미지 조회
    Optional<EventReviewImage> getImageById(Integer imageId); //이미지 하나만 조회
    EventReviewImage saveImage(EventReviewImage eventReviewImage); //이미지 저장
    void deleteImage(Integer imageId); //이미지 삭제
}
