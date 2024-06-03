package com.backend.androidProjectBE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin("*")
@RequestMapping("/api/v1")
public class RentalController {
    @GetMapping("/rentallmao/")
    public ResponseEntity<?> getAllVehicle() {
        return null;
    }
}
