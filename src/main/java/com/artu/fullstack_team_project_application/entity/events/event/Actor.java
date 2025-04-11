package com.artu.fullstack_team_project_application.entity.events.event;

import com.artu.fullstack_team_project_application.entity.users.user.UserImg;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prf_img_id", nullable = false)
    @ToString.Exclude
    private UserImg prfImg;

    @Column(name = "bday", nullable = false)
    private LocalDate bday;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agency_id", nullable = false)
    @ToString.Exclude
    private Agency agency;

    @Column(name = "is_joined", nullable = false)
    private Integer isJoined;

    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    private Set<ActorsImage> actorsImage = new LinkedHashSet<>();

    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    private Set<EventCast> eventCasts = new LinkedHashSet<>();
}