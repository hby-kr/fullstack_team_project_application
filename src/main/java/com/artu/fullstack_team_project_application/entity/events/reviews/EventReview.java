package com.artu.fullstack_team_project_application.entity.events.reviews;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.users.user.User;
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
@Entity
@ToString
@Table(name = "event_reviews")
public class EventReview {
    @Id
    @Column(name = "review_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "rate", nullable = false)
    private Integer rate;

    @Lob
    @Column(name = "contents", nullable = false)
    private String contents;

    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<EventReviewImage> eventReviews = new HashSet<>();

//    @Column(name="img_url", nullable = false)
//    private String imgUrl;
}