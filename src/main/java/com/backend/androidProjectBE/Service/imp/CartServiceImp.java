package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.CartItems;
import com.backend.androidProjectBE.dto.CartItemDTO;

import java.util.List;

public interface CartServiceImp {
    List<CartItemDTO> getAllVehicleSelected(int idUser);
    CartItemDTO getVehicleSelectedToListCart(int id);
    CartItemDTO changeRentalDate(CartItemDTO statusUpdateDTO);
    void removeSelectedVehicle(int id);
    boolean addToCart(Integer idVehicle, Integer userId);
    CartItemDTO findById(int id);
}
