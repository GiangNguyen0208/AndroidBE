package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.dto.UserDTO;
import com.backend.androidProjectBE.payload.request.SignupRequest;

import java.util.List;

public interface LoginServiceImp {
    List<UserDTO> getAllUser();
    boolean checkLogin(String fullname, String password);
//    boolean addUser(SignupRequest signupRequest);
}
