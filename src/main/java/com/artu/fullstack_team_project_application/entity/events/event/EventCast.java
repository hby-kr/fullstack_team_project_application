package com.artu.fullstack_team_project_application.entity.events.event;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@ToString
@Entity
@Table(name = "event_cast")
public class EventCast {
    @Id
    @Column(name = "cast_id", nullable = false)
    private Integer id;
    @Column(name = "user_id", nullable = false)
    private Integer user_id;
    @Column(name = "event_id", nullable = false)
    private Integer event_id;

    @Column(name = "is_joined", nullable = false)
    private Boolean isJoined = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    @ToString.Exclude
    @JsonBackReference

    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    @ToString.Exclude
    @JsonBackReference
    private User user;

    
    @Column(name = "actor_role", nullable = false)
    private String actorRole;

    
    @Column(name = "gender", nullable = false)
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "actor_id")
    @ToString.Exclude
    @JsonBackReference

    private Actor actor;



}