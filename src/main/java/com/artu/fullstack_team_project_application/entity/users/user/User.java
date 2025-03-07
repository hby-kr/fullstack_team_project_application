package com.artu.fullstack_team_project_application.entity.users.user;

import com.artu.fullstack_team_project_application.entity.events.event.*;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.events.reviews.EventReviewImage;
import com.artu.fullstack_team_project_application.entity.postings.Posting;
import com.artu.fullstack_team_project_application.entity.postings.PostingComment;
import com.artu.fullstack_team_project_application.entity.postings.PostingLike;
import com.artu.fullstack_team_project_application.entity.postings.UserFollow;
import com.artu.fullstack_team_project_application.entity.users.base.*;
import com.artu.fullstack_team_project_application.entity.widgets.Widget;
import com.artu.fullstack_team_project_application.entity.widgets.WidgetDetail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @Column(name = "user_email", nullable = false, length = 100)
    private String userEmail;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "user_birth", nullable = false)
    private LocalDate userBirth;

    @Lob
    @Column(name = "gender", nullable = false)
    private String gender;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("1")
    @Column(name = "is_used")
    private Boolean isUsed;

    @Column(name = "dropout_at")
    private Instant dropoutAt;

    @OneToMany(mappedBy = "user")
    private Set<EventCast> eventCasts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserEventLike> userEventLikes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<EventReviewImage> eventReviewImages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<EventReview> eventReviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Event> events = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Hashtag> hashtags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "writer")
    private Set<Message> messages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<PasswordChangeHistory> passwordChangeHistories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<PostingComment> postingComments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<PostingLike> postingLikes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Posting> postings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<SearchWord> searchWords = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserCart> userCarts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserCoupon> userCoupons = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserEnterChatroom> userEnterChatrooms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserEventBmark> userEventBmarks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserImg> userImgs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserInquire> userInquires = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserInterest> userInterests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserPoint> userPoints = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserPurchaseList> userPurchaseLists = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserSetting> userSettings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserloginLog> userloginLogs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<WidgetDetail> widgetDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Widget> widgets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "follower")
    private Set<UserFollow> userFollowers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "followee")
    private Set<UserFollow> userFollowees = new LinkedHashSet<>();

}