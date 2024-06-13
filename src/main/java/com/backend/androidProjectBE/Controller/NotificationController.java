package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.Notification;
import com.backend.androidProjectBE.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/send")
    public ResponseEntity<?> sendNotification(@RequestBody Notification notificationRequest) {
        service.sendNotificationToAllUsers(notificationRequest);
        JSONObject response = new JSONObject();
        try {
            response.put("title", notificationRequest.getTitle());
            response.put("message", notificationRequest.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error creating JSON response");
        }
        return ResponseEntity.ok().body(response.toString());
    }
}


