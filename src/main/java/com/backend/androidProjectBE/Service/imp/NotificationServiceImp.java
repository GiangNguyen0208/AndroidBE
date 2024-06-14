package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.dto.AnouncesDTO;

import java.util.List;

public interface NotificationServiceImp {
    List<AnouncesDTO> getAllNotifications();
    AnouncesDTO sendNoctify(AnouncesDTO anouncesDTO);
}