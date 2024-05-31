package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.dto.UserDTO;

import java.util.List;

public interface LoginServiceImp {
    List<UserDTO> getAllUser();
    boolean checkLogin(String email, String pass);
//
//    String checkUserEmail(String email);
//    String checkUserPasswordByEmail(String email);
//    Users getUserDetail(String email);
}
