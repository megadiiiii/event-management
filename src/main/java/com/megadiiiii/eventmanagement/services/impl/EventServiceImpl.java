package com.megadiiiii.eventmanagement.services.impl;

import com.megadiiiii.eventmanagement.dto.event.CreateEventDTO;
import com.megadiiiii.eventmanagement.dto.event.EventDetailDTO;
import com.megadiiiii.eventmanagement.dto.event.EventSummaryDTO;
import com.megadiiiii.eventmanagement.mapper.EventMapper;
import com.megadiiiii.eventmanagement.models.EventEntity;
import com.megadiiiii.eventmanagement.repository.EventRepo;
import com.megadiiiii.eventmanagement.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<EventSummaryDTO> findAllEvents() {
        List<EventEntity> events = eventRepo.findAll();
        return events.stream()
                .map(eventMapper::toEventSummaryDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDetailDTO createEvent(CreateEventDTO event) {
        EventEntity event = eventMapper.toCreateEventDTO(event);
    }
}
