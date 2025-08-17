package com.megadiiiii.eventmanagement.dto.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

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
    @NotNull(message = "Event start time is required")
    private LocalDateTime eventStartTime;
    @NotNull(message = "Event end time is required")
    private LocalDateTime eventEndTime;
    @NotBlank(message = "Event type is required")
    private String eventType;

    private List<MultipartFile> mediaFiles;
}
