package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Service.imp.MessageServiceImp;
import com.backend.androidProjectBE.dto.MessageDTO;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MessageController {
    private final MessageServiceImp messageServiceImp;

    public MessageController(MessageServiceImp messageServiceImp) {
        this.messageServiceImp = messageServiceImp;
    }

    @PostMapping("/message/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO message){
        ResponseEntity<String> response = null;
        if (message.getContent().isEmpty() || message.getFrom() == null || message.getTo() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please complete all field data");
        }else{
            if (messageServiceImp.sendMessage(message)){
                response = ResponseEntity.ok().body("success");
            }else{
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something went wrong, may be id not exist");
            }
        }

        return response;
    }

    @PostMapping("/message/read")
    public ResponseEntity<?> readMessages(@RequestBody UserDTO toUser){
        ResponseEntity<?> response = null;
        response = ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(messageServiceImp.getMessagesFor(toUser));
        return response;
    }
}
