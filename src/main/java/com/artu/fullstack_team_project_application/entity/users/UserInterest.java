package com.artu.fullstack_team_project_application.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "user_interests")
public class UserInterest {
    @EmbeddedId
    private UserInterestId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "interest_order", nullable = false)
    private Integer interestOrder;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ctgr_id", nullable = false)
    private com.artu.fullstack_team_project_application.entity.users.Category ctgr;

}