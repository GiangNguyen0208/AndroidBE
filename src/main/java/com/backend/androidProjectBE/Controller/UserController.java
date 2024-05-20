package com.backend.androidProjectBE.Controller;


import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("admin/getAllUser")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(userServiceImp.getAllUser(), HttpStatus.OK);
    }

}
