package com.artu.fullstack_team_project_application.entity.events.event;

import com.artu.fullstack_team_project_application.entity.events.reviews.EventReview;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.users.base.Category;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "event_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "location", length = 50)
    private String location;

    @Column(name = "company", nullable = false, length = 50)
    private String company;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "how_long", nullable = false)
    private int howLong;

    @Column(name = "ctgr_id", nullable = false)
    private byte ctgrId;

    @Column(name = "age_limit", nullable = false)
    private int ageLimit;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @ColumnDefault("0")
    @Column(name = "is_approved", nullable = false)
    private Boolean isApproved = false;

    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    @JsonBackReference
    @JsonIgnore
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ctgr_id", insertable = false, updatable = false)
    @ToString.Exclude
    @JsonBackReference // 자식의 엔터에서 부모와 관계를 적은 필드에 @JsonBackReference를 사용함.
    // @JsonIgnore
    private Category category;

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference // 부모 엔터티에서 자식 엔티티를 담는 필드에 @JsonManagedReference를 사용함.
    // 부모와 자식관계는 일대다의 관계로 만들어질 수 있다. 여기서도 일대다의 관계의 관계이고.
    private Set<EventImage> eventImages = new LinkedHashSet<>();


    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private Set<EventDetailImage> eventDetailImages = new LinkedHashSet<>();


    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private Set<EventReview> eventReview = new LinkedHashSet<>();

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private Set<EventCast> eventCast = new LinkedHashSet<>();


    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    @JsonIgnore
    private Set<EventDate> eventDates = new LinkedHashSet<>();


}