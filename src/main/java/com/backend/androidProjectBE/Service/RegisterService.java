package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Service.imp.RegisterServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements RegisterServiceImp {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean registerNewUserServiceMethod(Users users) {
        try {
            userRepository.save(users);
            return true; // Registration successful
        } catch (Exception e) {
            return false; // Registration failed
        }
    }
    // End of register New User Service Method
}
