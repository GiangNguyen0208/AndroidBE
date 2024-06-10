package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.Notification;
import com.backend.androidProjectBE.Service.NotificationService;

import java.util.List;

public interface NotificationServiceImp {
    List<Notification> getAllNotifications();
    Notification getNotificationById(int id);
    void deleteNotificationById(int id);
}
