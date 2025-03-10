package com.artu.fullstack_team_project_application.entity.users.user;

import com.artu.fullstack_team_project_application.entity.users.base.Category;
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
@Table(name = "user_interests")
@IdClass(UserInterestId.class)
public class UserInterest {

    @Id
    @Column (name = "user_id", nullable = false)
    private String userId;

    @Id
    @Column (name = "ctgr_id", nullable = false)
    private int ctgrId;


    @Column(name = "interest_order", nullable = false)
    private Integer interestOrder;

    // private boolean isUsed; // 이게 필요할까?


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private User user;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ctgr_id", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private Category ctgr;

}