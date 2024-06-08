package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.CartItems;
import com.backend.androidProjectBE.dto.CartItemDTO;

import java.util.List;

public interface CartServiceImp {
    List<CartItemDTO> getAllVehicleSelected();
    CartItemDTO getVehicleSelectedToListCart(int id);
    CartItemDTO changeRentalDate(int id, int rentalDate, String email, String phone, String address);
    void removeSelectedVehicle(int id);
    boolean addToCart(Integer idVehicle);
    CartItemDTO findById(int id);
}
