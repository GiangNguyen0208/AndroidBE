package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.Messages;
import com.backend.androidProjectBE.Entity.Roles;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.dto.MessageDTO;
import com.backend.androidProjectBE.dto.UserDTO;

import java.util.List;
import java.util.Set;

public interface MessageServiceImp {
    List<MessageDTO> getAllMessages(UserDTO user, boolean isToUser);
    List<MessageDTO> getMessagesFor(UserDTO user);
    boolean sendMessage(MessageDTO message);

    Set<Integer> getAdminMessage();
}
