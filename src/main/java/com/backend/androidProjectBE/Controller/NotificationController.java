package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.Anounces;
import com.backend.androidProjectBE.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/notify")
public class NotificationController {
    @Autowired
    private NotificationService service;

    @GetMapping("/read")
    public ResponseEntity<?> readNotification(){
        ResponseEntity<?> response = null;
        response = ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(service.readNotifications());
        return response;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendNotification(@RequestBody Anounces notificationRequest) {
        ResponseEntity<String> response = null;
        service.sendNotification(notificationRequest);
        response = ResponseEntity.ok().body("success");
        return response;


//        service.sendNotificationToAllUsers(notificationRequest);
//        JSONObject response = new JSONObject();
//        try {
//            response.put("title", notificationRequest.getTitle());
//            response.put("message", notificationRequest.getMessage());
//        } catch (JSONException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Error creating JSON response");
//        }
//        return ResponseEntity.ok().body(response.toString());
    }
}


