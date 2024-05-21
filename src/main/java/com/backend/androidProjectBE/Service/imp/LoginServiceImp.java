package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.dto.UserDTO;
import com.backend.androidProjectBE.payload.request.SignupRequest;
import org.apache.catalina.User;

import java.util.List;

public interface LoginServiceImp {
    List<UserDTO> getAllUser();
    boolean checkLogin(String email, String pass);
//
//    String checkUserEmail(String email);
//    String checkUserPasswordByEmail(String email);
//    Users getUserDetail(String email);
}
