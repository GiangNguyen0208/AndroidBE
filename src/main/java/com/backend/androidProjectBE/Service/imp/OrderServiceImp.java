package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Orders;
import com.backend.androidProjectBE.dto.OrderItemDTO;

import java.util.List;

public interface OrderServiceImp {
    List<OrderItemDTO> getAllOrderItem();
    OrderItemDTO addOrderItem(OrderItems orderItems);
    void removeOrderItem(int id);
}
