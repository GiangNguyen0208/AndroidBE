package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Service.imp.ShipperServiceImp;
import com.backend.androidProjectBE.dto.OrderItemDTO;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("*")
@RequestMapping("/api/v1")
public class ShipperController{
    @Autowired
    ShipperServiceImp shipperServiceImp;

    @GetMapping("/listOrder")
    public ResponseEntity<?> getAllOrders() {
        return new ResponseEntity<>(shipperServiceImp.listAllOrderItems(), HttpStatus.OK);
    }
    @PutMapping("{orderId}/setStatus")
    public ResponseEntity<OrderItems> setStatusOrder(@PathVariable int orderId, @RequestBody OrderItemDTO orderItemDTO) {
        OrderItems orderItems = shipperServiceImp.setStatusOrderItem(orderItemDTO, orderId);
        return new ResponseEntity<>(orderItems , HttpStatus.OK);
    }
}
