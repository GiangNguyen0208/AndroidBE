package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Service.NotificationService;
import com.backend.androidProjectBE.dto.AnouncesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/notify")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/read")
    public ResponseEntity<?> readNotification(){
        return new ResponseEntity<>( notificationService.getAllNotifications(), HttpStatus.OK);
    }

    @PostMapping("/send")
    public ResponseEntity<AnouncesDTO> sendNotification(@RequestBody AnouncesDTO anouncesDTO) {
        AnouncesDTO anouncesDTO1 = notificationService.sendNoctify(anouncesDTO);
        return new ResponseEntity<>(anouncesDTO1 , HttpStatus.OK);
    }

}