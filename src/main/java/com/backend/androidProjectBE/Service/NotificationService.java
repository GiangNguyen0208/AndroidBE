package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Anounces;
import com.backend.androidProjectBE.Repository.NotificationRepository;
import com.backend.androidProjectBE.Service.imp.NotificationServiceImp;
import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import com.backend.androidProjectBE.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService implements NotificationServiceImp {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserServiceImp userService;

    @Override
    public List<AnouncesDTO> getAllNotifications() {
        List<Anounces> noctifyList = notificationRepository.findAll();
        List<AnouncesDTO> messageDTOS = new ArrayList<>();
        for (Anounces anounces : noctifyList) {
            AnouncesDTO messageDTO = new AnouncesDTO();
            messageDTO.setId(anounces.getId());
            messageDTO.setTitle(anounces.getTitle());
            messageDTO.setContent(anounces.getContent());
            messageDTOS.add(messageDTO);
        }
        return messageDTOS;
    }

    @Override
    public AnouncesDTO sendNoctify(AnouncesDTO anouncesDTO) {
        AnouncesDTO aDTO = new AnouncesDTO();
        Anounces anounces = new Anounces();
        anounces.setTitle(anouncesDTO.getTitle());
        anounces.setContent(anouncesDTO.getContent());
        notificationRepository.save(anounces);
        aDTO.setTitle(anouncesDTO.getTitle());
        aDTO.setContent(anouncesDTO.getContent());
        return aDTO;
    }

}