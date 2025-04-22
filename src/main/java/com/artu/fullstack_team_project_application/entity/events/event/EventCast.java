package com.artu.fullstack_team_project_application.entity.events.event;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
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

    @Column(name = "event_id", nullable = false)
    private Integer eventId;

    @Column(name = "actor_id", nullable = false)
    private Integer actorId;

    @Column(name = "actor_role", nullable = false)
    private String Role;


    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    @ToString.Exclude
    @JsonBackReference
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "actor_id", insertable = false, updatable = false)
    // @JsonBackReference를 지운 이유는, 자식에서 부모를 참조해야 하기 때문에. 대신 메서드에서 강제조인 시켜줘야함.
    private Actor actor;

}