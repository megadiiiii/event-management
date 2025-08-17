package com.megadiiiii.eventmanagement.services;

import com.megadiiiii.eventmanagement.dto.event.CreateEventDTO;
import com.megadiiiii.eventmanagement.dto.event.EventDetailDTO;
import com.megadiiiii.eventmanagement.dto.event.EventSummaryDTO;

import java.util.List;

public interface EventService {
    List<EventSummaryDTO> findAllEvents();

    EventDetailDTO createEvent(CreateEventDTO createEventDTO);
}
