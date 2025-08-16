package com.megadiiiii.eventmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminController {
    @GetMapping("/admin")
    public String adminHomepage(){
        return "admin";
    }

    @GetMapping("/admin/event-create")
    public String eventCreatePage(){
        return "event-create";
    }
}
