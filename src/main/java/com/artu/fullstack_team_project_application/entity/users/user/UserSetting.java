package com.artu.fullstack_team_project_application.entity.users.user;

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
@Table(name = "user_settings")
public class UserSetting {
    @Id
    @Column(name = "setting_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ColumnDefault("'Light'")
    @Lob
    @Column(name = "display_color")
    private String displayColor;

    @ColumnDefault("'System'")
    @Lob
    @Column(name = "language")
    private String language;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "set_at")
    private Instant setAt;

}