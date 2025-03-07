package com.artu.fullstack_team_project_application.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name = "msg_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "writer", nullable = false)
    private User writer;

    @Lob
    @Column(name = "msg_body", nullable = false)
    private String msgBody;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ColumnDefault("0")
    @Column(name = "is_checked", nullable = false)
    private Boolean isChecked = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chatroom_id", nullable = false)
    private com.artu.fullstack_team_project_application.entity.users.Chatroom chatroom;

}