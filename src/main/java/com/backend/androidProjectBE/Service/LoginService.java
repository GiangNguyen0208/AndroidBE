package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Service.imp.LoginServiceImp;
import com.backend.androidProjectBE.dto.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceImp {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkLogin(String email, String password) {
        try {
            Users user = userRepository.findByEmail(email);
            return user != null && password.equals(user.getPassword());
        } catch (Exception e) {
            System.err.println("An error occurred while checking login: " + e.getMessage());
            return false;
        }
    }

    @Override
    public UserLogin getUserByEmail(String email) {
        try {
            Users user = userRepository.findByEmail(email);
            if (user == null) {
                return null;
            }
            UserLogin userLogin = new UserLogin();
            userLogin.setId(user.getId());
            userLogin.setEmail(user.getEmail());
            userLogin.setRoles(user.getRoles().getName());
            return userLogin;
        } catch (Exception e) {
            System.err.println("An error occurred while retrieving user details: " + e.getMessage());
            return null;
        }
    }
}
