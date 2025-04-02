package com.artu.fullstack_team_project_application.entity.events.reviews;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.users.user.User;
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
@Table(name = "event_review_images") //DB에 매핑될 테이블 이름
public class EventReviewImage {
    @Id //기본 키
    @Column(name = "image_id", nullable = false)
    private Integer id;
    @Column(name = "event_id", nullable = false)
    private int eventId;
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

<<<<<<< HEAD
    @ManyToOne(fetch = FetchType.LAZY, optional = false) // 이미지는 유저 한명 (N:1 관계)
    @OnDelete(action = OnDeleteAction.CASCADE) // 유저 삭제 시 이미지 삭제
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user; //유저 엔티티와 연관 관계 (userId는 읽기 전용)
=======
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false,insertable = false, updatable = false)
    private User user;
>>>>>>> 04f1bd76182b72c1b76c28d57829d0431553d856

    @ManyToOne(fetch = FetchType.LAZY, optional = false) //이미지는 공연 한개 (N:1 관계)
    @JoinColumn(name = "event_id", nullable = false, insertable = false, updatable = false)
    private Event event; //공연 엔티티와 연관 관계 (eventId는 읽기 전용)

    @Column(name = "img_url", nullable = false)
    private String imgUrl; // 저장된 이미지 URL

    @ColumnDefault("CURRENT_TIMESTAMP") //생성 시간 기본값 설정
    @Column(name = "create_at", nullable = false)
    private Instant createAt; // 이미지 업로드 시각

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // 이미지는 리뷰 하나 (N:1)
    @JoinColumn(name="review_id", nullable = false)
    private EventReview eventReview; // 어떤 리뷰에 속한 이미지 인지


}