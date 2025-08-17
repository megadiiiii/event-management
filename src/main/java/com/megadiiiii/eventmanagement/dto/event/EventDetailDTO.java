package com.megadiiiii.eventmanagement.dto.event;

import com.megadiiiii.eventmanagement.dto.ticket.TicketSummaryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EventDetailDTO {
    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private LocalDateTime eventStartTime;
    private LocalDateTime eventEndTime;
    private String eventType;
    private List<TicketSummaryDTO> tickets;
}
