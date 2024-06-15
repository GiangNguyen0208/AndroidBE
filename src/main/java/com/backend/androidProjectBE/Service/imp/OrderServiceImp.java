package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.CartItems;
import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Orders;
import com.backend.androidProjectBE.dto.CartItemDTO;
import com.backend.androidProjectBE.dto.OrderItemDTO;

import java.util.List;

public interface OrderServiceImp {
    boolean addOrderItem(CartItemDTO cartItemDTO);
    List<OrderItemDTO> findAll(int iduser);
    List<OrderItemDTO> getHistoryOrderContinue(int iduser);
    List<OrderItemDTO> getHistoryOrderCompleted(int iduser);
    void removeOrderItem(int id);
    OrderItemDTO getCartItemToPay(int cartItemId);
    OrderItemDTO getDetail(int idOrderItem);
}
