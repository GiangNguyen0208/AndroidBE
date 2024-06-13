package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Notification;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Service.imp.NotificationServiceImp;
import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService implements NotificationServiceImp {
    @Autowired
    private UserServiceImp userServiceImp;

    public List<Notification> getAllNotifications() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("Khuyến mãi", "Giảm 50% cho chuyến đầu"));
        notifications.add(new Notification("Tin tức", "Chưa có tin tức nào"));
        return notifications;
    }

    public void sendNotificationToAllUsers(Notification notification) {
        List<UserDTO> users = userServiceImp.getAllUsers();
        for (UserDTO user : users) {
            sendNotification(user, notification);
        }
    }
    private void sendNotification(UserDTO user, Notification notification) {
        System.out.println("Sending notification to " + user.getUsername() + " with email " + user.getEmail());
    }
}