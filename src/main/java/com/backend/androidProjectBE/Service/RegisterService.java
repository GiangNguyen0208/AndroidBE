package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Roles;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.RolesRepository;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Service.imp.RegisterServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements RegisterServiceImp {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public boolean registerNewUserServiceMethod(Users users) {
        try {

            Roles role = rolesRepository.findById(1).orElseThrow(() -> new RuntimeException("Role not found"));
            users.setRoles(role); 
            
            userRepository.save(users);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }   
    
}