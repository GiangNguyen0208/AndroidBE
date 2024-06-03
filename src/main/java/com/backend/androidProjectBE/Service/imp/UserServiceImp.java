package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.dto.UserDTO;

public interface UserServiceImp {
    Users updateUser(int id, UserDTO userDTO);
    UserDTO loadUsers(int id);
}
