package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Service.UserService;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        Users updatedUser = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}
