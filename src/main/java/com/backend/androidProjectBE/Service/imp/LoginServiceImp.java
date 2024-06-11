package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.dto.UserLogin;

public interface LoginServiceImp {
    boolean checkLogin(String email, String password);
    UserLogin getUserByEmail(String email);
}
