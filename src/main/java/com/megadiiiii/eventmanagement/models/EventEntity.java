package com.megadiiiii.eventmanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_description", columnDefinition = "longtext")
    private String eventDescription;

    @Column(name = "event_location")
    private String eventLocation;

    @Column(name = "event_start_time")
    private LocalDateTime eventStartTime;

    @Column(name = "event_end_time")
    private LocalDateTime eventEndTime;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "create_time", updatable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(name = "update_time")
    @UpdateTimestamp
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketEntity> tickets;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventMediaEntity> mediaList = new ArrayList<>();
}
