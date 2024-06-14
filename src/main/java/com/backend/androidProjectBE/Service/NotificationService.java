package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Anounces;
import com.backend.androidProjectBE.Repository.NotificationRepository;
import com.backend.androidProjectBE.Service.imp.NotificationServiceImp;
import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import com.backend.androidProjectBE.dto.NotificationDTO;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService implements NotificationServiceImp {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private NotificationRepository notificationRepository;

    public List<NotificationDTO> readNotifications() {
        List<Anounces> anouncesList = new ArrayList<>();
        System.out.print("1"+notificationRepository.findAll());
        anouncesList.addAll(notificationRepository.findAll());
        return convertFrom(anouncesList);
    }

    private List<NotificationDTO> convertFrom(List<Anounces> list){
        List<NotificationDTO> res = new ArrayList<>(list.size());

        for (Anounces m: list){
            NotificationDTO i = new NotificationDTO();
            i.setTitle(m.getTitle());
            i.setBody(m.getContent());
            res.add(i);
        }
        return res;
    }


    public void sendNotification(Anounces notification) {
        Anounces newanounces = new Anounces();
        newanounces.setTitle(notification.getTitle());
        newanounces.setContent(notification.getContent());
        notificationRepository.save(newanounces);
    }

    @Override
    public List<Anounces> getAllNotifications() {
        return List.of();
    }
}