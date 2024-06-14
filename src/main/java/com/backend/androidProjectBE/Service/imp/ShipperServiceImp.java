package com.backend.androidProjectBE.Service.imp;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.dto.OrderItemDTO;

import java.util.List;

public interface ShipperServiceImp {
    List<OrderItemDTO> listAllOrderItems();
    OrderItemDTO findOrderItemById(int id);
    OrderItemDTO setStatusOrderItem(OrderItemDTO orderItemDTO, int idOrder);
}
