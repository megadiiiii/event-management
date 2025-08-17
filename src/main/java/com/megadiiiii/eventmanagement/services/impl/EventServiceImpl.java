package com.megadiiiii.eventmanagement.services.impl;

import com.megadiiiii.eventmanagement.dto.event.CreateEventDTO;
import com.megadiiiii.eventmanagement.dto.event.EventDetailDTO;
import com.megadiiiii.eventmanagement.dto.event.EventSummaryDTO;
import com.megadiiiii.eventmanagement.mapper.EventMapper;
import com.megadiiiii.eventmanagement.models.EventEntity;
import com.megadiiiii.eventmanagement.models.EventMediaEntity;
import com.megadiiiii.eventmanagement.repository.EventRepo;
import com.megadiiiii.eventmanagement.services.EventService;
import com.megadiiiii.eventmanagement.services.R2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private R2Service r2Service;

    @Override
    public List<EventSummaryDTO> findAllEvents() {
        List<EventEntity> events = eventRepo.findAll();
        return events.stream()
                .map(eventMapper::toEventSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventDetailDTO createEvent(CreateEventDTO createEventDTO) {
        // Map DTO -> Entity
        EventEntity eventEntity = eventMapper.toEntity(createEventDTO);

        // Chắc chắn mediaList không null
        if (eventEntity.getMediaList() == null) {
            eventEntity.setMediaList(new ArrayList<>());
        }

        // Xử lý upload file
        List<MultipartFile> files = createEventDTO.getMediaFiles();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String url = r2Service.uploadFile(file); // public URL
                        EventMediaEntity media = EventMediaEntity.builder()
                                .mediaUrl(url)
                                .event(eventEntity)
                                .build();
                        eventEntity.getMediaList().add(media);
                    } catch (IOException e) {
                        throw new RuntimeException("Upload file failed", e);
                    }
                }
            }
        }

        // Lưu entity
        eventRepo.save(eventEntity);

        // Map lại -> DTO trả về
        return eventMapper.toEventDetailDTO(eventEntity);
    }
}
