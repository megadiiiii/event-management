package com.megadiiiii.eventmanagement.mapper;

import com.megadiiiii.eventmanagement.dto.event.CreateEventDTO;
import com.megadiiiii.eventmanagement.dto.event.EventDetailDTO;
import com.megadiiiii.eventmanagement.dto.event.EventSummaryDTO;
import com.megadiiiii.eventmanagement.dto.event.UpdateEventDTO;
import com.megadiiiii.eventmanagement.models.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TicketMapper.class})
public interface EventMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    EventEntity toEntity(CreateEventDTO dto);

    EventDetailDTO toEventDetailDTO(EventEntity event);
    EventSummaryDTO toEventSummaryDTO(EventEntity event);
    CreateEventDTO toCreateEventDTO(EventEntity event);
    UpdateEventDTO toUpdateEventDTO(EventEntity event);
}

