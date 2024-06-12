package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.Notification;
import com.backend.androidProjectBE.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService service;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return service.getAllNotifications();
    }
}

