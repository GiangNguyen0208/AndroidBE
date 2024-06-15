package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Roles;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.RoleRepository;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Service.imp.RolesServiceImp;
import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import com.backend.androidProjectBE.dto.RoleDTO;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

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
        userDTO.setIsAdminMessage(user.getIsAdminMessage());
        return userDTO;
    }

    public UserDTO updateUser(int id, UserDTO usersChange) {
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
        user.setIsAdminMessage(usersChange.getIsAdminMessage());
        Optional<Roles> r = roleRepository.findByName(usersChange.getRoleName());
        if (r.isPresent())
            user.setRoles(r.get());
        Users u = userRepository.save(user);
        return convertToDTO(u);
    }


    public UserDTO loadUsers(int id) {
        Optional<Users> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            UserDTO userResponseDTO = new UserDTO();
            userResponseDTO.setId(user.getId());
            userResponseDTO.setFirstname(user.getFirstname());
            userResponseDTO.setLastname(user.getLastname());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setPassword(user.getPassword());
            userResponseDTO.setPhone(user.getPhone());
            userResponseDTO.setGender(user.getGender());
            userResponseDTO.setBirthDay(user.getBirthDay());
            userResponseDTO.setRoleName(user.getRoles().getName());
            userResponseDTO.setIsAdminMessage(user.getIsAdminMessage());
            return userResponseDTO;
        } else {
            throw new RuntimeException("User not found");
        }
    }


    public List<RoleDTO> getRoles() {
        return roleRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private RoleDTO convertToDTO(Roles role) {
        RoleDTO result = RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .dateCreate(role.getDateCreate()).build();
        return result;
    }
}
