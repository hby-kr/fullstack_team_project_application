package com.artu.fullstack_team_project_application.entity.postings;

import com.artu.fullstack_team_project_application.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "postings")
public class Posting {
    @Id
    @Column(name = "post_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Lob
    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "location_tag")
    private String locationTag;

    @ColumnDefault("'All'")
    @Lob
    @Column(name = "visibility_type")
    private String visibilityType;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "edit_at")
    private Instant editAt;

    @ColumnDefault("1")
    @Column(name = "is_used")
    private Boolean isUsed;

}