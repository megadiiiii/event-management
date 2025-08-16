package com.megadiiiii.eventmanagement.dto.event;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateEventDTO {
    @NotBlank(message = "Event name is required")
    private String eventName;
    @NotBlank(message = "Event description is required")
    private String eventDescription;
    @NotBlank(message = "Event location is required")
    private String eventLocation;
    @NotBlank(message = "Event start time is required")
    private LocalDateTime eventStartTime;
    @NotBlank(message = "Event end time is required")
    private LocalDateTime eventEndTime;
    @NotBlank(message = "Event type is required")
    private String eventType;
}
