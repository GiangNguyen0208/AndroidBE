package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService implements UserServiceImp {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertToDTO(Users user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setGender(user.getGender());
        userDTO.setPhone(user.getPhone());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthDay(user.getBirthDay());
        userDTO.setRoleName(user.getRoles().getName());
        return userDTO;
    }

    @Override
    public Users updateUser(int id, Users usersChange) {
        Optional<Users> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User not found");
        }
        Users user = userOptional.get();
        user.setFirstname(usersChange.getFirstname());
        user.setLastname(usersChange.getLastname());
        user.setEmail(usersChange.getEmail());
        user.setPassword(user.getPassword());
        user.setGender(usersChange.getGender());
        user.setPhone(usersChange.getPhone());
        user.setBirthDay(usersChange.getBirthDay());

        return userRepository.save(user);
    }


    @Override
    public UserDTO loadUsers(int id) {
        Optional<Users> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            UserDTO userResponseDTO = new UserDTO();
            userResponseDTO.setFirstname(user.getFirstname());
            userResponseDTO.setLastname(user.getLastname());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setPassword(user.getPassword());
            userResponseDTO.setPhone(user.getPhone());
            userResponseDTO.setGender(user.getGender());
            userResponseDTO.setBirthDay(user.getBirthDay());

            return userResponseDTO;
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
