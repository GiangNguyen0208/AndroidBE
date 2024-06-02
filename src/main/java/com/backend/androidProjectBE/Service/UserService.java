package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users updateUser(int id, UserDTO userDTO) {
        Optional<Users> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User not found");
        }

        Users user = userOptional.get();
        user.setEmail(userDTO.getEmail());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setPassword(user.getPassword());
        user.setGender(userDTO.getGender());
        user.setPhone(userDTO.getPhone());
        user.setStatus(true);
        user.setBirthDay(userDTO.getBirthDay());

        return userRepository.save(user);
    }
}
