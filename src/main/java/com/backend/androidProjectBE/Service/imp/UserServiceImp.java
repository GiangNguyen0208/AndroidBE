package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.dto.UserDTO;

import java.util.List;

public interface UserServiceImp {
    List<UserDTO> getAllUsers();
    Users updateUser(int id, Users users);
    UserDTO loadUsers(int id);
}
