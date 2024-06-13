package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.dto.OrderItemDTO;

import java.util.List;

public interface ShipperServiceImp {
    List<OrderItemDTO> listAllOrderItems();
    OrderItems setStatusOrderItem(OrderItemDTO orderItemDTO, int idOrder);
}
