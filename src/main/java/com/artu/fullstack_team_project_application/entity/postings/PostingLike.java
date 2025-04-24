package com.artu.fullstack_team_project_application.entity.postings;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@SQLDelete(sql = "UPDATE postings SET is_used = true WHERE post_id = ?")
@Where(clause = "is_used = true")
@Table(name = "posting_like")
@IdClass(PostingLikeId.class)
public class PostingLike {
    // @EmbeddedId
    // private PostingLikeId id;

    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Id
    @Column(name = "post_id", nullable = false)
    private Integer postId;


    // @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    // @MapsId("postId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference
    private Posting post;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "liked_at")
    private Instant likedAt;

    @ColumnDefault("1")
    @Column(name = "is_used")
    private Boolean isUsed;

}