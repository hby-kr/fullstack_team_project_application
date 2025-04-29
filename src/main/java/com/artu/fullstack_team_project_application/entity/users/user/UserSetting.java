package com.artu.fullstack_team_project_application.entity.users.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    public enum DisplayColor {Light, Dark;
        public static DisplayColor fromString(String value) {
            for (DisplayColor color : DisplayColor.values()) {
                if (color.name().equalsIgnoreCase(value)) {
                    return color;
                }
            }
            throw new IllegalArgumentException("Unknown DisplayColor: " + value);
        }
    }

    public enum Language {ko, en, ja, zh}

    @Id
    @Column(name = "setting_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer settingId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"password", "userBirth", "gender", "createdAt", "isUsed", "dropoutAt", "events", "hibernateLazyInitializer", "handler"})
    private User user;
//    @JsonBackReference

    @ColumnDefault("'Light'")
//    @Lob
    @Column(name = "display_color")
    @Enumerated(EnumType.STRING)
    private DisplayColor displayColor;

    @ColumnDefault("'System'")
//    @Lob
    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Language language;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "set_at")
    private Instant setAt;

}