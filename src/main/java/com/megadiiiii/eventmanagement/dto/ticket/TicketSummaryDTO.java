package com.megadiiiii.eventmanagement.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketSummaryDTO {
    private Long id;
    private String ticketType;
    private int ticketPrice;
    private Integer ticketQuantity;
}
