package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.CartItems;
import com.backend.androidProjectBE.Entity.Vehicles;
import com.backend.androidProjectBE.Repository.CartRepository;
import com.backend.androidProjectBE.Repository.VehiclesRepository;
import com.backend.androidProjectBE.Service.imp.CartServiceImp;
import com.backend.androidProjectBE.dto.CartDTO;
import com.backend.androidProjectBE.dto.CartItemDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CartService implements CartServiceImp {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    VehiclesRepository vehiclesRepository;

    @Override
    public List<CartItemDTO> getAllVehicleSelected() {
        List<CartItems> cartItemsList = cartRepository.findAll();
        List<CartItemDTO> cartItemDTOList = new ArrayList<>();
        for (CartItems items : cartItemsList) {
            Date rentalDate = items.getRentals().getRentalDate();
            Date returnDate = items.getRentals().getReturnDate();
            rentalDate =  new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            returnDate = calendar.getTime();
            CartItemDTO cartItemDTO = CartItemDTO.builder()
                    .id(items.getId())
                    .vehicleid(items.getVehicles().getId())
                    .nameVehicle(items.getVehicles().getName())
                    .price(items.getVehicles().getPrice())
                    .brandVehicle(items.getVehicles().getBrands().getName())
                    .rental_day(1)
                    .rentalDate(rentalDate)
                    .returnDate(returnDate)
                    .build();
            cartItemDTOList.add(cartItemDTO);
        }
        return cartItemDTOList;
    }

@Override
public CartItemDTO  getVehicleSelectedToListCart(int id) {
        Vehicles vehicles = vehiclesRepository.findById(id);
        Date rentalDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1); // Set return date based on quantity (days)
        Date returnDate = calendar.getTime();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .vehicleid(vehicles.getId())
                .nameVehicle(vehicles.getName())
                .brandVehicle(vehicles.getBrands().getName())
                .price(vehicles.getPrice())
                .rentalDate(rentalDate)
                .returnDate(returnDate)
                .rental_day(1)
                .build();
        return cartItemDTO;
}


    @Override
    public CartItemDTO changeRentalDate(int id, int day) {
        CartItems cartItems = cartRepository.findById(id);
        Date rentalDate = cartItems.getRentals().getRentalDate();
        Date returnDate = cartItems.getRentals().getReturnDate();
        rentalDate =  new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, day);
        returnDate = calendar.getTime();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .id(cartItems.getId())
                .vehicleid(cartItems.getVehicles().getId())
                .nameVehicle(cartItems.getVehicles().getName())
                .price(cartItems.getVehicles().getPrice()*day)
                .brandVehicle(cartItems.getVehicles().getBrands().getName())
                .rental_day(day)  // Maăặc định hin thi thuê 1 ngày, có tther thay doi
                .rentalDate(rentalDate)
                .returnDate(returnDate)
                .build();
        return cartItemDTO;
    }

    @Override
    public void removeSelectedVehicle(int cartItemId) {
        if (cartRepository.existsById(cartItemId)) {
            cartRepository.deleteById(cartItemId);
        } else {
            throw new RuntimeException("CartItem not found with id " + cartItemId);
        }
    }
}
