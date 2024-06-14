package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.Anounces;
import com.backend.androidProjectBE.dto.AnouncesDTO;
import com.backend.androidProjectBE.dto.MessageDTO;
import com.backend.androidProjectBE.dto.OrderItemDTO;

import java.util.List;

public interface NotificationServiceImp {
    List<AnouncesDTO> getAllNotifications();
    AnouncesDTO sendNoctify(AnouncesDTO anouncesDTO);
}