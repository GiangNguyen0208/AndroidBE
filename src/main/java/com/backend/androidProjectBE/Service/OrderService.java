package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Vehicles;
import com.backend.androidProjectBE.Repository.OrderItemsRepository;
import com.backend.androidProjectBE.Service.imp.OrderServiceImp;
import com.backend.androidProjectBE.dto.OrderItemDTO;
import com.backend.androidProjectBE.dto.VehiclesDTO;
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
            OrderItemDTO orderItemDTO = map(o);
            orderItemDTOS.add(orderItemDTO);
        }
        return orderItemDTOS;
    }
    @Override
    public OrderItemDTO addOrderItem(OrderItems orderItems) {
        OrderItems items = orderItemsRepository.save(orderItems);
        OrderItemDTO orderItemDTO = map(orderItems);
        return orderItemDTO;
    }

    @Override
    public void removeOrderItem(int id) {
        orderItemsRepository.deleteById(id);
    }

    private OrderItemDTO map(OrderItems object) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setVehicleId(object.getVehicles().getId());
        orderItemDTO.setName(object.getVehicles().getName());
        orderItemDTO.setPrice(object.getVehicles().getPrice());
        orderItemDTO.setBrand(object.getVehicles().getBrands().getName());
        return orderItemDTO;
    }
}
