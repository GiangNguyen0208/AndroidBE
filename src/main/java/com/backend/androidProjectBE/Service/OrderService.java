package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Repository.OrderItemsRepository;
import com.backend.androidProjectBE.Service.imp.OrderServiceImp;
import com.backend.androidProjectBE.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Override
    public List<OrderItemDTO> getAllOrderItem() {
        List<OrderItems> orderItemsList = orderItemsRepository.findAll();
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();

        for (OrderItems o : orderItemsList) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setVehicleId(o.getVehicles().getId());
            orderItemDTO.setName(o.getVehicles().getName());
            orderItemDTO.setPrice(o.getVehicles().getPrice());
            orderItemDTO.setBrand(o.getVehicles().getBrands().getName());
            orderItemDTOS.add(orderItemDTO);
        }
        return orderItemDTOS;
    }
    @Override
    public OrderItemDTO addOrderItem(OrderItems orderItems) {
        OrderItems items = orderItemsRepository.save(orderItems);
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setVehicleId(items.getVehicles().getId());
        orderItemDTO.setName(items.getVehicles().getName());
        orderItemDTO.setPrice(items.getVehicles().getPrice());
        orderItemDTO.setBrand(items.getVehicles().getBrands().getName());

        return orderItemDTO;
    }

    @Override
    public void removeOrderItem(int id) {
        orderItemsRepository.deleteById(id);
    }
}
