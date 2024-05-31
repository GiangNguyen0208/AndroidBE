package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Service.imp.LoginServiceImp;
import com.backend.androidProjectBE.dto.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    // @Qualifier(ten Bean) --- Giup lay ra dung cai class tren IOC de su dung, trong TH co 2 class trung ten nhau, chir khac nhua ten Bean.
    LoginServiceImp loginServiceImp;

    @PostMapping("/user/signin")
    public ResponseEntity signin(@RequestBody UserLogin users) {
        System.out.println("Triggered!");
        if (loginServiceImp.checkLogin(users.getEmail(), users.getPassword())) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please Register Before Login");
        }
    }
}
