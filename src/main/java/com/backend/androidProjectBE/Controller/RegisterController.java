package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Service.UserService;
import com.backend.androidProjectBE.Service.imp.RegisterServiceImp;
import com.backend.androidProjectBE.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RegisterController {

    @Autowired
    RegisterServiceImp registerServiceImp;

    @PostMapping("/user/register")
    public ResponseEntity<?> registerNewUser(@RequestBody Users users) {
        if (users.getFirstname().isEmpty() || users.getLastname().isEmpty() || users.getEmail().isEmpty() || users.getPassword().isEmpty()) {
            return new ResponseEntity<>("Please Complete all field data", HttpStatus.BAD_REQUEST);
        }
        // Encryt / Hash Password
//        String hashed_password = BCrypt.hashpw(users.getPassword(), BCrypt.gensalt());
        users.setPassword(users.getPassword());

        /// Register New User:
        boolean isRegistered = registerServiceImp.registerNewUserServiceMethod(users);

        if (isRegistered) {
            return ResponseEntity.ok(Result.builder().message("Registration success").build());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }
}


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Result {
    private String message;
}
