package com.artu.fullstack_team_project_application.entity.events.reviews;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity // JPA 에서 엔티티 인식
@ToString
@Table(name = "event_reviews") //DB에 매핑될 테이블 이름
public class EventReview {
    @Id //기본 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //리뷰 ID가 자동 증가하면서 생성
    @Column(name = "review_id", nullable = false)
    private Integer id; //리뷰 고유 번호

    @ManyToOne(fetch = FetchType.LAZY, optional = false) //리뷰는 유저 한명 (N:1 관계)
    @JoinColumn(name = "user_id", nullable = false) // 외래 키 설정
    @ToString.Exclude // 순환 참조 방지 (ToString 에서 제외)
    @JsonBackReference // JSON 직렬화 시 순환참조 방지
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) //리뷰는 공연 한개에 속함(N:1 관계)
    @JoinColumn(name = "event_id", nullable = false) // 외래 키 설정
    @ToString.Exclude
    @JsonBackReference
    private Event event;

    @Column(name = "rate", nullable = false)
    private Integer rate;

    @Lob // 긴 텍스트 저장용 (Large Object)
    @Column(name = "contents", nullable = false)
    private String contents;

    @ColumnDefault("1") // DB 기본값 : 1 (true 로 사용되기 위해)
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false; //사용 여부 (노출 여부)

    @ColumnDefault("CURRENT_TIMESTAMP") // DB 에서 기본 생성 시간 지정
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "eventReview", fetch = FetchType.LAZY) //여러 이미지 연결(1:N)
    private Set<EventReviewImage> eventReviewImages = new HashSet<>(); // 리뷰 이미지 목록

}