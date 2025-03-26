package com.artu.fullstack_team_project_application.entity.events.event;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.users.base.Category;
import com.artu.fullstack_team_project_application.entity.events.tickets.EventDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {
    @Id
    @Column(name = "event_id", nullable = false)
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
    private Integer howLong;

    @Column(name = "ctgr_id", nullable = false)
    private Byte ctgrId;


    @Column(name = "age_limit", nullable = false)
    private String ageLimit;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @ColumnDefault("0")
    @Column(name = "is_approved", nullable = false)
    private Boolean isApproved = false;

    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false,insertable = false, updatable = false)
    @ToString.Exclude
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ctgr_id", nullable = false,insertable = false, updatable = false)
    @ToString.Exclude
    @JsonBackReference

    private Category ctgr;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<EventDate>eventDates=new LinkedHashSet<>();

    @OneToMany(mappedBy = "post")
    private Set<EventImage> EventImages=new LinkedHashSet<>();

}