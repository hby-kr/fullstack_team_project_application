package com.artu.fullstack_team_project_application.entity.users.user;

import com.artu.fullstack_team_project_application.entity.events.event.*;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.postings.Posting;
import com.artu.fullstack_team_project_application.entity.postings.PostingComment;
import com.artu.fullstack_team_project_application.entity.postings.PostingLike;
import com.artu.fullstack_team_project_application.entity.postings.UserFollow;
import com.artu.fullstack_team_project_application.entity.users.base.*;
import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@SQLDelete(sql = "UPDATE users SET is_used = false WHERE post_id = ?")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
// @SQLDelete 는 실제로 DELETE 명령어를 사용하지 않고, 대신 UPDATE 명령어를 사용하여 is_used 필드를 false로 변경.
@Where(clause = "is_used = true") // 특정 조건을 만족하는 데이터를 조회할 때 추가적인 필터를 적용하는 데 사용
// is_used = true 라는 조건을 추가하여, is_used가 true 인 항목만 조회되도록 설정
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    public enum Gender {M, F}
    public enum Role { USER, ADMIN, MANAGER }

    @Id
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @Column(name = "user_email", nullable = false, length = 100)
    private String userEmail;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "user_birth", nullable = false)
    private LocalDate userBirth;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "memo")
    private String memo;


    //  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @Column(name = "created_at")
    private LocalDate createdAt;

    @ColumnDefault("true")
    @Column(name = "is_used")
    private Boolean isUsed = true;

    @Column(name = "dropout_at")
    private LocalDate dropoutAt;

//  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ join 설정 시작
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @JsonBackReference
    private Set<UserEventLike> userEventLikes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<EventReview> eventReviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    @ToString.Exclude
    private Set<Event> events = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<Hashtag> hashtags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<Message> messages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<PasswordChangeHistory> passwordChangeHistories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @ToString.Exclude
    private Set<PostingComment> postingComments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Set<PostingLike> postingLikes = new LinkedHashSet<>();

    // Posting 엔티티와의 관계 설정
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Set<Posting> postings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<SearchWord> searchWords = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<UserCart> userCarts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<UserCoupon> userCoupons = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<UserEnterChatroom> userEnterChatrooms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<UserEventBmark> userEventBmarks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Set<UserImg> userImgs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Set<UserInquire> userInquires = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<UserInterest> userInterests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<UserPoint> userPoints = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<UserPurchaseList> userPurchaseLists = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Set<UserSetting> userSettings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<UserloginLogs> userloginLogs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Set<WidgetDetail> widgetDetails = new LinkedHashSet<>();

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @JsonBackReference
//    @ToString.Exclude
//    private Set<Widget> widgets = new LinkedHashSet<>();

    // UserFollow 엔티티와의 관계 설정
    @OneToMany(mappedBy = "followers")
    @OrderBy("followedAt ASC") // 정렬
    @ToString.Exclude
    @JsonIgnore
    private Set<UserFollow> followers = new LinkedHashSet<>();

    // UserFollow 엔티티와의 관계 설정
    @OneToMany(mappedBy = "followees")
    @OrderBy("followedAt ASC") // 정렬
    @ToString.Exclude
    @JsonIgnore
    private Set<UserFollow> followees = new LinkedHashSet<>();


}