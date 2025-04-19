package com.artu.fullstack_team_project_application.entity.users.base;

import com.artu.fullstack_team_project_application.entity.events.event.Event;
import com.artu.fullstack_team_project_application.entity.users.user.UserInterest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "ctgr_id", nullable = false)
    private byte id;

    @Column(name = "ctgr_name", nullable = false, length = 50)
    private String ctgrName;

    @Column(name = "is_used_main", nullable = false)
    private Boolean isUsedMain = false;

    @Column(name = "is_used_oneday", nullable = false)
    private Boolean isUsedOneday = false;

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    @JsonManagedReference
    private Set<Event> events = new LinkedHashSet<>();

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    @JsonManagedReference
    private Set<UserInterest> userInterests = new LinkedHashSet<>();

}