package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
//
//    @Override
//    public List<UserDTO> getAllUser() {
//        List<Users> listUser = userRepository.findAll();
//        List<UserDTO> userDTOList = new ArrayList<>();
//        for (Users u: listUser) {
//            UserDTO userDTO = new UserDTO();
//            userDTO.setId(u.getId());
//            userDTO.setEmail(u.getEmail());
//            userDTO.setBirthDay(u.getBirthDay());
//            userDTO.setPassword(u.getPassword());
//
//            userDTOList.add(userDTO);
//        }
//        return userDTOList;
//    }



}
