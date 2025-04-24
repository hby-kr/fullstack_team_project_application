package com.artu.fullstack_team_project_application.entity.users.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user_img")
public class UserImg {
    @Id
    @Column(name = "prf_img_id", nullable = false)
    private Integer prfImgId;

    @Column(name = "prf_img_url", nullable = false)
    private String prfImgUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"password", "userBirth", "gender", "createdAt", "isUsed", "dropoutAt"})
    private User user;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "create_at")
    private Instant createAt;

}