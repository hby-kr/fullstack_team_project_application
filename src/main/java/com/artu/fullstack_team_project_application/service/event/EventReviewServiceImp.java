package com.artu.fullstack_team_project_application.service.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.repository.event.EventReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventReviewServiceImp implements EventReviewService {//인터페이스에서 약속했던 기능들을 실제로 구현
    private final EventReviewRepository eventReviewRepository;

    public EventReviewServiceImp(EventReviewRepository eventReviewRepository) {
        this.eventReviewRepository = eventReviewRepository;
    } // 스프링이 이걸 통해 eventReviewRepository 를 자동으로 주입

    @Override
    public List<EventReview> getAllEventReviews() {
        return eventReviewRepository.findAll();
    } //모든 리뷰 가져오는 기능

    @Override
    public List<EventReview> getReviewsByEventId(Integer eventId) {
        return eventReviewRepository.findByEventId(eventId);
    } // 공연 ID 로 리뷰 조회

    @Override
    public List<EventReview> getReviewsByUserId(String userId) {
        return eventReviewRepository.findByUser_UserId(userId);
    } // 사용자 ID 로 리뷰 조회

    @Override
    public Optional<EventReview> getReviewById(Integer reviewId) {
        return eventReviewRepository.findById(reviewId);
    } // 리뷰 ID 로 리뷰 조회

    @Override
    public EventReview registerReview(EventReview eventReview) { // 리뷰 등록
        eventReview.setCreatedAt(LocalDateTime.now()); // 작성 시간 설정
        eventReview.setIsUsed(true); // 사용 상태 true 로 지정
        return eventReviewRepository.save(eventReview); // DB에 저장
    }

    @Override
    public EventReview saveReview(Integer reviewId, String content, Integer rate) {
        Optional<EventReview> optEventReview = eventReviewRepository.findById(reviewId);
        if (optEventReview.isPresent()) {
            EventReview eventReview = optEventReview.get();
            eventReview.setContents(content); //리뷰 내용 수정
            eventReview.setRate(rate); // 리뷰 별점 수정
            return eventReviewRepository.save(eventReview);
        } else { //만약 null 이면
            throw new RuntimeException("리뷰를 찾을 수 없습니다.");
        }
    }

    @Override
    public void removeReview(Integer reviewId) {
        eventReviewRepository.deleteById(reviewId);
    }
}