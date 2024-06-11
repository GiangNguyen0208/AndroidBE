package com.backend.androidProjectBE.Controller;


import com.backend.androidProjectBE.Service.imp.CartServiceImp;
import com.backend.androidProjectBE.Service.imp.VehiclesServiceImp;
import com.backend.androidProjectBE.dto.CartItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
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
    public ResponseEntity<?> addToCart(@RequestParam Integer idVehicle) {
        boolean success = cartServiceImp.addToCart(idVehicle);
        if (success) {
            return ResponseEntity.ok(Result.builder().message("Vehicle added to cart successfully.").build());
        } else {
            return ResponseEntity.ok(Result.builder().message("Vehicle not found.").build());
        }
    }
    // Change rental date
    @GetMapping("/rental/setstate")
    public ResponseEntity<?> getDetailVehicleRental(@RequestParam int cartItemId, @RequestParam int day, @RequestParam String email, @RequestParam String phone, @RequestParam String address) {
        return new ResponseEntity<>(cartServiceImp.changeRentalDate(cartItemId, day, email, phone, address), HttpStatus.OK);
    }
    // Remove Selected
    @DeleteMapping("/rental/delete/{id}")
    public String deleteCartItem(@PathVariable int id) {
        try {
            cartServiceImp.removeSelectedVehicle(id);
            return "CartItem with id " + id + " has been deleted.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
