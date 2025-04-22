package com.artu.fullstack_team_project_application.entity.events.event;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "event_detail_images")
public class EventDetailImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id", nullable = false)
    private int id;

    @Column(name = "event_id", nullable = false)
    private int eventId;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @Column(name = "img_order", nullable = false)
    private int imgOrder;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    @ToString.Exclude
    @JsonBackReference
    private Event event;


}