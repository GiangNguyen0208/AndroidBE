package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Service.imp.LoginServiceImp;
import com.backend.androidProjectBE.payload.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    // @Qualifier(ten Bean) --- Giup lay ra dung cai class tren IOC de su dung, trong TH co 2 class trung ten nhau, chir khac nhua ten Bean.
    LoginServiceImp loginServiceImp;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String email, @RequestParam String password) {
        ResponseData responseData = new ResponseData();
        if (loginServiceImp.checkLogin(email, password)) {
            responseData.setData(true);
            responseData.setStatus(200);
        } else {
            responseData.setData(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

//    @PostMapping("/signup")
//    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
//        ResponseData responseData = new ResponseData();
//
//        if (loginServiceImp.addUser(signupRequest)) {
//            responseData.setData(true);
//            responseData.setStatus(200);
//        } else {
//            responseData.setData(false);
//        }
//
////        responseData.setData(loginServiceImp.addUser(signupRequest));
//
//        return new ResponseEntity<>(responseData, HttpStatus.OK);
//    }
}
