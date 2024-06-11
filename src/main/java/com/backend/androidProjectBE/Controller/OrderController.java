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
    @GetMapping("/order/add")
    public ResponseEntity<?> getCartItemToPay(@RequestBody OrderItems orderItem) {
        return new ResponseEntity<>(orderServiceImp.addOrderItem(orderItem), HttpStatus.OK);
    }
    @GetMapping("/order")
    public ResponseEntity<?> findAllOrder() {
        return new ResponseEntity<>(orderServiceImp.findAll(), HttpStatus.OK);
    }
}
