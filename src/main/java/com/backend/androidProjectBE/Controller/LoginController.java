package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Service.imp.LoginServiceImp;
import com.backend.androidProjectBE.dto.UserLogin;
import com.backend.androidProjectBE.payload.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
        if (loginServiceImp.checkLogin(users.getEmail(), users.getPassword())) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please Register Before Login");
        }
        // Get Email User
//        String userEmail = loginServiceImp.checkUserEmail(users.getEmail());
//        // Check if Email is Empty
//        if (userEmail.isEmpty() || userEmail == null) {
//            return new ResponseEntity("Email does not exist", HttpStatus.NOT_FOUND);
//        }
//        String hashPass = loginServiceImp.checkUserPasswordByEmail(users.getEmail());
//        // Validate User Password
//        if (BCrypt.checkpw(users.getPassword(), hashPass)) {
//            return new ResponseEntity("Incorrect username or password", HttpStatus.BAD_REQUEST);
//        }
//        // Set User Object;
//        Users Users = loginServiceImp.getUserDetail(users.getEmail());
//        return new ResponseEntity(users, HttpStatus.OK);
    }
}
