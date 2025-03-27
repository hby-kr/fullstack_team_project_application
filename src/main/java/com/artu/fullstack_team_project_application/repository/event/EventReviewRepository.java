package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 이 인터페이스가 Spring 이 관리하는 Repository bean (DB랑 연결)
public interface EventReviewRepository extends JpaRepository<EventReview, Integer> {//EventReview 엔티티를 관리하고, 기본키 타입은 Integer
    List<EventReview> findByEventId(Integer eventId); //공연에 대한 모든 리뷰를 조회 (SELECT * FROM event_reviews WHERE event_id =?)
    List<EventReview> findByUser_UserId(String userId); //유저가 작성한 리뷰들 조회 (SELECT * FROM event_reviews WHERE user_id =?)
}
