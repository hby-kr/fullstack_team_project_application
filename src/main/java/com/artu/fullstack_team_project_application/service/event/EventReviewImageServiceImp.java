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
public class EventReviewImageServiceImp implements EventReviewImageService { //EventReviewImageService 인터페이스 구현해서 로직을 정의
    private final EventReviewImageRepository eventReviewImageRepository;
    public EventReviewImageServiceImp(EventReviewImageRepository eventReviewImageRepository) {
        this.eventReviewImageRepository = eventReviewImageRepository;
    } // 스프링이 이걸 통해 eventReviewImageRepository 를 자동으로 주입

    @Override
    public List<EventReviewImage> getImagesByReviewId(Integer reviewId) {
        return eventReviewImageRepository.findByReviewId(reviewId);
    } // 리뷰 ID 로 조회

    @Override
    public List<EventReviewImage> getImagesByEvent_EventId(Integer eventId) {
        return eventReviewImageRepository.findByEvent_EventId(eventId);
    }// 공연 ID 로 조회


    @Override
    public Optional<EventReviewImage> getImageById(Integer imageId) {
        return eventReviewImageRepository.findById(imageId);
    } // 이미지 ID 로 조회

    @Override
    @Transactional
    public EventReviewImage saveImage(EventReviewImage eventReviewImage) {
        eventReviewImage.setCreateAt(Instant.now());
        return eventReviewImageRepository.save(eventReviewImage);
    } // 이미지 업로드시 저장

    @Override
    @Transactional
    public void deleteImage(Integer imageId) {
        eventReviewImageRepository.deleteById(imageId);
    } // 이미지 삭제
}
