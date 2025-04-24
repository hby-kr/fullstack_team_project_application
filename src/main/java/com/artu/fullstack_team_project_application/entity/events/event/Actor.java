package com.artu.fullstack_team_project_application.entity.events.event;

import com.artu.fullstack_team_project_application.entity.users.user.UserImg;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
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

    public enum Gender {M, F}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "bday", nullable = false)
    private LocalDate bday;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "agency_id", nullable = false)
    private Boolean agencyId = false;

    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;


    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id", insertable = false, updatable = false)
    @ToString.Exclude
    @JsonBackReference
    private Agency agency;

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    @OneToMany(mappedBy = "actor" , fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<ActorsImage> actorsImages = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "actor")
//    @ToString.Exclude
//    @JsonManagedReference
//    private Set<EventCast> eventCasts = new LinkedHashSet<>();


}