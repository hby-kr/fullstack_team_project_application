package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;

import java.util.List;
import java.util.Optional;

public interface EventReviewService {
    //리뷰 전부 다 가져오기
    List<EventReview> getAllEventReviews();
    // 공연에 대한 모든 리뷰 조회
    List<EventReview> getReviewsByEventId(Integer eventId);
    // 유저가 쓴 리뷰 조회
    List<EventReview> getReviewsByUserId(String userId);
    // 리뷰 하나 상세조회
    Optional<EventReview> getReviewById(Integer reviewId);
    // 리뷰 등록
    EventReview registerReview(EventReview eventReview);
    // 기존 리뷰 수정(내용,평점)
    EventReview saveReview(Integer reviewId, String content, Integer rate);
    // 리뷰 삭제
    void removeReview(Integer reviewId);

}
