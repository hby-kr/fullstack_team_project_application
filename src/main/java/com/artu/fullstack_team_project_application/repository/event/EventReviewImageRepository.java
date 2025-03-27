package com.artu.fullstack_team_project_application.repository.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 이 인터페이스를 Spring 이 관리하는 Repository bean (DB랑 연결)
public interface EventReviewImageRepository extends JpaRepository<EventReviewImage, Integer> {//EventReviewImage 엔티티를 관리하고, 기본키 타입은 Integer
    List<EventReviewImage> findByUser_UserId(String userId); //유저아이디별 이미지 조회
    List<EventReviewImage> findByEventId(Integer eventId); // 공연별 이미지 조회
}
