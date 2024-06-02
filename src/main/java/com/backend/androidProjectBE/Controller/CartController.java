package com.backend.androidProjectBE.Controller;


import com.backend.androidProjectBE.Entity.CartItems;
import com.backend.androidProjectBE.Service.imp.CartServiceImp;
import com.backend.androidProjectBE.dto.CartItemDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CartController {
    @Autowired
    CartServiceImp cartServiceImp;
    // Get List Vehicle add to Cart
    @GetMapping("/rental/")
    public ResponseEntity<?> getAllVehicleSelected() {
        return new ResponseEntity<>(cartServiceImp.getAllVehicleSelected(), HttpStatus.OK);
    }

    // Get Detail Vehicle and view rental date and return date
    @GetMapping("/rental/add")
    public ResponseEntity<CartItemDTO> addToCart(@RequestParam int id) {
        return new ResponseEntity<>(cartServiceImp.getVehicleSelectedToListCart(id), HttpStatus.OK);
    }
    // Change rental date
    @GetMapping("/rental/detail/setDay")
    public ResponseEntity<?> getDetailVehicleRental(@RequestParam int cartItemId, @RequestParam int dayRental) {
        return new ResponseEntity<>(cartServiceImp.changeRentalDate(cartItemId, dayRental), HttpStatus.OK);
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
