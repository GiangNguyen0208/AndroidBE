package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.CartItems;
import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Orders;
import com.backend.androidProjectBE.dto.OrderItemDTO;

import java.util.List;

public interface OrderServiceImp {
    OrderItems addOrderItem(OrderItems orderItem);
    List<OrderItems> findAll();
    void removeOrderItem(int id);
    OrderItemDTO getCartItemToPay(int cartItemId);
}
