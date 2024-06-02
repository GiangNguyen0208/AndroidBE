package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Service.imp.LoginServiceImp;
import com.backend.androidProjectBE.dto.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    private final LoginServiceImp loginServiceImp;

    @Autowired
    public LoginController(LoginServiceImp loginServiceImp) {
        this.loginServiceImp = loginServiceImp;
    }

    @PostMapping("/user/signin")
    public ResponseEntity<?> signin(@RequestBody UserLogin userLogin) {
        try {
            String email = userLogin.getEmail();
            String password = userLogin.getPassword();

            if (loginServiceImp.checkLogin(email, password)) {
                UserLogin responseUser = loginServiceImp.getUserByEmail(email);
                if (responseUser == null) {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
                }
                return ResponseEntity.ok(responseUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect email or password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing your request");
        }
    }
}
