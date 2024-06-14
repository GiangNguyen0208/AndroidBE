package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Messages;
import com.backend.androidProjectBE.Entity.Roles;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.MessageRepository;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Service.imp.MessageServiceImp;
import com.backend.androidProjectBE.Utils.Constraints;
import com.backend.androidProjectBE.dto.MessageDTO;
import com.backend.androidProjectBE.dto.RoleDTO;
import com.backend.androidProjectBE.dto.UserDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.function.Function;

@Service
public class MessageService implements MessageServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    private List<MessageDTO> convertFrom(List<Messages> list){
        List<MessageDTO> res = new ArrayList<>(list.size());
        for (Messages m: list){
            MessageDTO i = new MessageDTO();
            i.setId(m.getId());
            i.setFrom(m.getFromUser().getId());
            i.setTo(m.getToUser().getId());;
            i.setContent(m.getContent());
            i.setCreateAt(m.getDateCreate());
            i.setFromFirstName(userRepository.findById(m.getFromUser().getId()).getFirstname());
            i.setToFirstName(userRepository.findById(m.getToUser().getId()).getFirstname());
            res.add(i);
        }
        return res;
    }

    @Override
    public List<MessageDTO> getAllMessages(UserDTO user, boolean isToUser) {
        List<Messages> messages = new ArrayList<>();
        if (isToUser){
            messages.addAll(messageRepository.findByToUser(userRepository.findById(user.getId().intValue())));
        }else{
            messages.addAll(messageRepository.findByFromUser(userRepository.findById(user.getId().intValue())));
        }
        return convertFrom(messages);
    }

    @Override
    public List<MessageDTO> getMessagesFor(UserDTO user) {
        Users u = userRepository.findById(user.getId().intValue());

        List<Messages> messages = messageRepository.findByToUser(u);
        messages.addAll(messageRepository.findByFromUser(u));

        return convertFrom(messages);
    }


    //Check if customer send message to other customer
    private boolean isCustomerToCustomer(Users from, Users to){
        return from.getRoles().getId() == Constraints.USER_ROLE && to.getRoles().getId() == Constraints.USER_ROLE;
    }

    @Override
    public boolean sendMessage(MessageDTO message) {
        Users from = userRepository.findById(message.getFrom().intValue());
        Users to = userRepository.findById(message.getTo().intValue());

        if (from == null || to == null ||from.getId() == to.getId() || isCustomerToCustomer(from, to)){
            return false;
        }
        Messages newMessage = new Messages();
        newMessage.setContent(message.getContent());
        newMessage.setFromUser(from);
        newMessage.setToUser(to);
        newMessage.setDateCreate(Date.from(Instant.now()));
        messageRepository.save(newMessage);
        return true;
    }

    @Override
    public Set<Integer> getAdminMessage() {
        Set<Integer> admins = new HashSet<>();
        for (Users u: userRepository.findByIsAdminMessageTrue()){
            admins.add(u.getId());
        }
        return admins;
    }

}
