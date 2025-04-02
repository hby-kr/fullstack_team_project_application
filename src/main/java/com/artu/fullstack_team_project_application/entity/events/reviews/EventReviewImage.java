package com.artu.fullstack_team_project_application.entity.events.reviews;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@ToString
@Entity // JPA 에서 엔티티로 인식
@Table(name = "event_review_images") //DB에 매핑 될 테이블 이름
public class EventReviewImage {
    @Id //기본 키
    @GeneratedValue(strategy = GenerationType.IDENTITY)//이미지 ID 자동 증가 생성
    @Column(name = "image_id", nullable = false)
    private Integer id;
    @Column(name = "review_id", nullable = false)
    private Integer reviewId;

    @Column(name = "img_url", nullable = false)
    private String imgUrl; // 저장된 이미지 URL

    @ColumnDefault("CURRENT_TIMESTAMP") //생성 시간 기본값 설정
    @Column(name = "create_at", nullable = false)
    private Instant createAt; // 이미지 업로드 시각

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // 이미지는 리뷰 하나 (N:1)
    @JoinColumn(name="review_id", nullable = false, insertable = false, updatable = false)
    @ToString.Exclude
    @JsonBackReference
    private EventReview eventReview; // 어떤 리뷰에 속한 이미지 인지


}