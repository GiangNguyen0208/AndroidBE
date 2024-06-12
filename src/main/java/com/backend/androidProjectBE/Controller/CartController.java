package com.backend.androidProjectBE.Controller;


import com.backend.androidProjectBE.Service.imp.CartServiceImp;
import com.backend.androidProjectBE.Service.imp.VehiclesServiceImp;
import com.backend.androidProjectBE.dto.CartItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
public class CartController {
    @Autowired
    CartServiceImp cartServiceImp;

    @Autowired
    VehiclesServiceImp vehiclesServiceImp;

    // Get List Vehicle add to Cart
    @GetMapping("/rental")
    public ResponseEntity<?> getAllVehicleSelected() {
        return new ResponseEntity<>(cartServiceImp.getAllVehicleSelected(), HttpStatus.OK);
    }

    @GetMapping("/rental/pay")
    public ResponseEntity<?> getCartItemToPayment(@RequestParam int cartItemId) {
        return new ResponseEntity<>(cartServiceImp.getVehicleSelectedToListCart(cartItemId), HttpStatus.OK);
    }

    // Get Detail Vehicle and view rental date and return date
    @PostMapping("/rental/add")
    public ResponseEntity<?> addToCart(@RequestParam Integer idVehicle, @RequestParam Integer userId) {
        boolean success = cartServiceImp.addToCart(idVehicle, userId);
        if (success) {
            return ResponseEntity.ok(Result.builder().message("Vehicle added to cart successfully.").build());
        } else {
            return ResponseEntity.ok(Result.builder().message("Vehicle not found.").build());
        }
    }
    // Change rental date
    @PostMapping("/rental/setstate")
    public ResponseEntity<?> getDetailVehicleRental(@RequestBody CartItemDTO statusUpdateDTO) {
        return new ResponseEntity<>(cartServiceImp.changeRentalDate(statusUpdateDTO), HttpStatus.OK);
    }
    // Remove Selected
    @DeleteMapping("/rental/delete/{id}")
    public ResponseEntity<?> deleteCartItem(@PathVariable int id) {
        cartServiceImp.removeSelectedVehicle(id);
        return ResponseEntity.ok(Result.builder().message("Remove successfully.").build());
    }
}
