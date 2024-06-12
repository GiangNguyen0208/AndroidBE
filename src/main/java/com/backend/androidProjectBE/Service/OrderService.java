package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.CartItems;
import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Orders;
import com.backend.androidProjectBE.Repository.CartRepository;
import com.backend.androidProjectBE.Repository.OrderRepository;
import com.backend.androidProjectBE.Service.imp.OrderServiceImp;
import com.backend.androidProjectBE.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository  cartRepository;


    @Override
    public OrderItems addOrderItem(OrderItems orderItem) {
//        return orderRepository.save(orderItem);
        return null;
    }

    @Override
    public List<Orders> findAll() {
        List<Orders> orderItemsList = orderRepository.findAll();
        return orderItemsList;
    }

    @Override
    public void removeOrderItem(int id) {
        orderRepository.deleteById(id);
    }


    // Thanh toan
    @Override
    public OrderItemDTO getCartItemToPay(int cartItemId) {
        CartItems cartItems = cartRepository.findById(cartItemId);

        OrderItemDTO orderItemDTO = OrderItemDTO.builder()
                .vehicleid(cartItems.getVehicles().getId())
                .nameVehicle(cartItems.getVehicles().getName())
                .brandVehicle(cartItems.getVehicles().getBrands().getName())
                .imageLink(cartItems.getVehicles().getImages().getImgLink())
                .rentalDate(cartItems.getRentals().getRentalDate())
                .returnDate(cartItems.getRentals().getReturnDate())
                .rental_day(cartItems.getRental_day())
                .address(cartItems.getAddress())
                .phone(cartItems.getPhone())
                .email(cartItems.getEmail())
                .build();
        return orderItemDTO;
    }
}
