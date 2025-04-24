package com.artu.fullstack_team_project_application.entity.postings;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@SQLDelete(sql = "UPDATE postings SET is_used = true WHERE post_id = ?")
@Where(clause = "is_used = true")
@Table(name = "postings")
public class Posting {
    @Id
    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    private User user;

    @Lob
    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "location_tag")
    private String locationTag;

    @JoinColumn(name = "person_tag_id")
    private String personTagId;

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

    // 게시물 이미지 조인
    @OneToMany(mappedBy = "post")
     @OrderBy("imgOrder ASC") // 정렬
    @JsonManagedReference
    private Set<PostingImage> postingImages = new LinkedHashSet<>();

    // 게시물 댓글 조인
     @OneToMany(mappedBy = "post")
     @JsonManagedReference
    private Set<PostingComment> postingComments = new LinkedHashSet<>();

}