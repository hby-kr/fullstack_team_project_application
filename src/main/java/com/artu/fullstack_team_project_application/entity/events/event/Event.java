package com.artu.fullstack_team_project_application.entity.events.event;

import com.artu.fullstack_team_project_application.entity.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ColumnDefault("'0'")
    @Lob
    @Column(name = "age_limit", nullable = false)
    private String ageLimit;

    @Column(name = "how_long", nullable = false)
    private Integer howLong;

    @ColumnDefault("0")
    @Column(name = "is_approved", nullable = false)
    private Boolean isApproved = false;

    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ctgr_id", nullable = false)
    private com.artu.fullstack_team_project_application.entity.users.Category ctgr;

}