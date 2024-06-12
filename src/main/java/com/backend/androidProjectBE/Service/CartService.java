package com.backend.androidProjectBE.Service;


import com.backend.androidProjectBE.Entity.CartItems;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Entity.Vehicles;
import com.backend.androidProjectBE.Repository.CartRepository;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Repository.VehiclesRepository;
import com.backend.androidProjectBE.Service.imp.CartServiceImp;
import com.backend.androidProjectBE.dto.CartItemDTO;
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

    @Autowired
    UserRepository userRepository;

    @Override
    public List<CartItemDTO> getAllVehicleSelected() {
        List<CartItems> cartItemsList = cartRepository.findAll();
        List<CartItemDTO> cartItemDTOList = new ArrayList<>();
        for (CartItems items : cartItemsList) {
            Date rentalDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, items.getRental_day()); // Set return date based on quantity (days)
            Date returnDate = calendar.getTime();
            CartItemDTO cartItemDTO = CartItemDTO.builder()
                    .id(items.getId())
                    .vehicleid(items.getVehicles().getId())
                    .nameVehicle(items.getVehicles().getName())
                    .price(items.getVehicles().getPrice())
                    .brandVehicle(items.getVehicles().getBrands().getName())
                    .rental_day(items.getRental_day())
                    .rentalDate(rentalDate)
                    .returnDate(returnDate)
                    .imageLink(items.getVehicles().getImages().getImgLink())
                    .build();
            cartItemDTOList.add(cartItemDTO);
        }
        return cartItemDTOList;
    }

@Override
public CartItemDTO  getVehicleSelectedToListCart(int id) {
        CartItems cartItems = cartRepository.findById(id);
        Date rentalDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1); // Set return date based on quantity (days)
        Date returnDate = calendar.getTime();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .vehicleid(cartItems.getId())
                .nameVehicle(cartItems.getVehicles().getName())
                .brandVehicle(cartItems.getVehicles().getBrands().getName())
                .price(cartItems.getVehicles().getPrice())
                .rentalDate(rentalDate)
                .returnDate(returnDate)
                .rental_day(1)
                .build();
        return cartItemDTO;
}


//    @Override
//    public CartItemDTO changeRentalDate(int id, int day, String email, String phone, String address) {
//        CartItems cartItems = cartRepository.findById(id);
//        Date rentalDate = new Date();
//        rentalDate =  new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_YEAR, day);
//        Date returnDate = calendar.getTime();
//        CartItemDTO cartItemDTO = CartItemDTO.builder()
//                .id(cartItems.getId())
//                .vehicleid(cartItems.getVehicles().getId())
//                .nameVehicle(cartItems.getVehicles().getName())
//                .price(cartItems.getVehicles().getPrice()*day)
//                .brandVehicle(cartItems.getVehicles().getBrands().getName())
//                .rental_day(day)
//                .rentalDate(rentalDate)
//                .returnDate(returnDate)
//                .email(email)
//                .phone(phone)
//                .address(address)
//                .build();
//        cartRepository.deleteById(id);
//        return cartItemDTO;
//    }

    @Override
    public CartItemDTO changeRentalDate(CartItemDTO statusUpdateDTO) {
        CartItems cartItems = cartRepository.findById(statusUpdateDTO.getId()).get();
        Date rentalDate = statusUpdateDTO.getRentalDate();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, statusUpdateDTO.getDay());
        Date returnDate = calendar.getTime();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .id(cartItems.getId())
                .vehicleid(cartItems.getVehicles().getId())
                .nameVehicle(cartItems.getVehicles().getName())
                .price(cartItems.getVehicles().getPrice()*statusUpdateDTO.getDay())
                .brandVehicle(cartItems.getVehicles().getBrands().getName())
                .rental_day(statusUpdateDTO.getDay())
                .rentalDate(rentalDate)
                .returnDate(returnDate)
                .email(statusUpdateDTO.getEmail())
                .phone(statusUpdateDTO.getPhone())
                .address(statusUpdateDTO.getAddress())
                .build();
        return cartItemDTO;
    }

    @Override
    public void removeSelectedVehicle(int cartItemId) {
        cartRepository.deleteById(cartItemId);
    }
    @Override
    public boolean addToCart(Integer idVehicle, Integer userId) {
        Vehicles vehicles = vehiclesRepository.findById(idVehicle).get();
        Users users = userRepository.findById(userId).get();

        if (vehicles !=  null && users != null) {
            CartItems cartItems = CartItems.builder()
                    .vehicles(vehicles)
                    .users(users)
                    .rental_day(1)
                    .build();
            cartRepository.save(cartItems);
            return true;
        }
        return false;
    }
    @Override
    public CartItemDTO findById(int id) {
        Vehicles vehicles = vehiclesRepository.findById(id);
        Date rentalDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1); // Set return date based on quantity (days)
        Date returnDate = calendar.getTime();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .vehicleid(vehicles.getId())
                .nameVehicle(vehicles.getName())
                .price(vehicles.getPrice()*(1-vehicles.getDiscounts().getValue()))
                .rentalDate(rentalDate)
                .returnDate(returnDate)
                .build();
        return cartItemDTO;
    }
}
