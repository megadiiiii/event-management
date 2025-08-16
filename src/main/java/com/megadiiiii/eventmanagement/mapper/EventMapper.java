package com.megadiiiii.eventmanagement.mapper;

import com.megadiiiii.eventmanagement.dto.event.CreateEventDTO;
import com.megadiiiii.eventmanagement.dto.event.EventDetailDTO;
import com.megadiiiii.eventmanagement.dto.event.EventSummaryDTO;
import com.megadiiiii.eventmanagement.dto.event.UpdateEventDTO;
import com.megadiiiii.eventmanagement.models.EventEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    //EventDetail to DTO
    EventDetailDTO toEventDetailDTO(EventEntity event);

    //EventSumarry to DTO
    EventSummaryDTO toEventSummaryDto(EventEntity event);

    //CreateEvent Mapper
    CreateEventDTO toCreateEventDTO(EventEntity event);

    //UpdateEvent
    UpdateEventDTO toUpdateEventDTO(EventEntity event);
};
