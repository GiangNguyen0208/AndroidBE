package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.CartItems;
import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Service.imp.OrderServiceImp;
import com.backend.androidProjectBE.dto.CartItemDTO;
import com.backend.androidProjectBE.dto.OrderItemDTO;
import com.backend.androidProjectBE.dto.VehiclesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    OrderServiceImp orderServiceImp;
    @PostMapping("/order/add")
    public ResponseEntity<?> getCartItemToPay(@RequestBody CartItemDTO cartItems) {
        boolean addSuccess = orderServiceImp.addOrderItem(cartItems);
        if (addSuccess) {
            return ResponseEntity.ok(Result.builder().message("Payment successfully. Go to Sleep !!!5").build());
        } else {
            return ResponseEntity.ok(Result.builder().message("Payment Fail.").build());
        }
    }
    @GetMapping("/order")
    public ResponseEntity<?> findAllOrder() {
        return new ResponseEntity<>(orderServiceImp.findAll(), HttpStatus.OK);
    }
}
