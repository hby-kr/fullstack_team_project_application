package com.artu.fullstack_team_project_application.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user_enter_chatroom")
public class UserEnterChatroom {
    @EmbeddedId
    private UserEnterChatroomId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "entered_at", nullable = false)
    private Instant enteredAt;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chat_id", nullable = false)
    private com.artu.fullstack_team_project_application.entity.users.Chatroom chat;

}