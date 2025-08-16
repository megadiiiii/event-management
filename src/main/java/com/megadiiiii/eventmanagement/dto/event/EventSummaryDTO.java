package com.megadiiiii.eventmanagement.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EventSummaryDTO {
    private String eventName;
    private String eventLocation;
    private LocalDateTime eventStartTime;
    private LocalDateTime eventEndTime;
    private String eventType;
}
