package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Notification;
import com.backend.androidProjectBE.Service.imp.NotificationServiceImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService implements NotificationServiceImp {

    public List<Notification> getAllNotifications() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification(1L, "Khuyến mãi", "Giảm 50% cho chuyến đầu"));
        notifications.add(new Notification(2L, "Tin tức", "Chưa có tin tức nào"));
        return notifications;
    }

    @Override
    public Notification getNotificationById(int id) {
        return null;
    }

    @Override
    public void deleteNotificationById(int id) {

    }
}