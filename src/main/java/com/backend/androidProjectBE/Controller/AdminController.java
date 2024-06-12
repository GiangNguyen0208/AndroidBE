package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Service.UserService;
import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        UserDTO user = userServiceImp.loadUsers(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody Users users) {
        Users updatedUser = userServiceImp.updateUser(id, users);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUserList() {
        return new ResponseEntity<>(userServiceImp.getAllUsers(), HttpStatus.OK);
    }
}

