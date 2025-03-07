package com.artu.fullstack_team_project_application.entity.events.event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "agency")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agency_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @OneToMany
    private Set<com.artu.fullstack_team_project_application.entity.events.event.Actor> actors = new LinkedHashSet<>();

}