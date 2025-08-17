package com.megadiiiii.eventmanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class EventMediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "media_url", columnDefinition = "longtext")
    private String mediaUrl;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventEntity event;
}
