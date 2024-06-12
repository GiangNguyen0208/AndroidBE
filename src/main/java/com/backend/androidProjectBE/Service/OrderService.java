package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.*;
import com.backend.androidProjectBE.Repository.CartRepository;
import com.backend.androidProjectBE.Repository.OrderRepository;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Repository.VehiclesRepository;
import com.backend.androidProjectBE.Service.imp.OrderServiceImp;
import com.backend.androidProjectBE.dto.CartItemDTO;
import com.backend.androidProjectBE.dto.OrderDTO;
import com.backend.androidProjectBE.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository  cartRepository;

    @Autowired
    VehiclesRepository vehiclesRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean addOrderItem(CartItemDTO cartItemDTO) {
        Vehicles vehicles = vehiclesRepository.findById(cartItemDTO.getVehicleid()).get();
        Users users = userRepository.findById(cartItemDTO.getUserid());

        if (vehicles != null && users != null) {
            OrderItems orderItem = OrderItems.builder()
                    .vehicles(vehicles)
                    .users(users)
                    .price(cartItemDTO.getPrice()) // Assuming you want to set the price correctly
                    .address(cartItemDTO.getAddress())
                    .email(cartItemDTO.getEmail())
                    .phone(cartItemDTO.getPhone())
                    .rentalDate(cartItemDTO.getRentalDate())
                    .returnDate(cartItemDTO.getReturnDate())
                    .build();
            orderRepository.save(orderItem);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderItems> findAll() {
        List<OrderItems> orderItemsList = orderRepository.findAll();
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
