package com.megadiiiii.eventmanagement.controller;

import com.megadiiiii.eventmanagement.dto.event.CreateEventDTO;
import com.megadiiiii.eventmanagement.models.EventEntity;
import com.megadiiiii.eventmanagement.services.EventService;
import com.megadiiiii.eventmanagement.services.R2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class adminController {
    private final EventService eventService;
    private final R2Service r2Service;

    @Autowired
    public adminController(EventService eventService, R2Service r2Service) {
        this.eventService = eventService;
        this.r2Service = r2Service;
    }

    @GetMapping("/admin")
    public String adminHomepage() {
        return "admin";
    }

    @GetMapping("/admin/event-create")
    public String eventCreatePage(Model model) {
        EventEntity eventEntity = new EventEntity();
        model.addAttribute("eventDTO", new CreateEventDTO());
        return "event-create";
    }

    @PostMapping("/admin/event-create")
    public String eventCreatePage(@ModelAttribute CreateEventDTO eventDTO) {
        eventService.createEvent(eventDTO);
        return "redirect:/test";
    }

    @GetMapping("/admin/test")
    public String adminTest() {
        return "admin-test";
    }
}
