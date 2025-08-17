package com.megadiiiii.eventmanagement.mapper;

import com.megadiiiii.eventmanagement.dto.ticket.TicketSummaryDTO;
import com.megadiiiii.eventmanagement.models.TicketEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    TicketSummaryDTO toDTO(TicketEntity entity);
    TicketEntity toEntity(TicketSummaryDTO dto);
}
