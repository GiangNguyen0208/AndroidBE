package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.OrderRepository;
import com.backend.androidProjectBE.Service.imp.ShipperServiceImp;
import com.backend.androidProjectBE.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShipperService implements ShipperServiceImp {

    @Autowired
    OrderRepository orderRepository;


    @Override
    public List<OrderItemDTO> listAllOrderItems() {
        List<OrderItems> orderItemList = orderRepository.findAll();
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        for (OrderItems orderItem : orderItemList) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setId(orderItem.getId());
            orderItemDTO.setEmail(orderItem.getEmail());
            orderItemDTO.setPhone(orderItem.getPhone());
            orderItemDTO.setAddress(orderItem.getAddress());
            orderItemDTO.setBrandVehicle(orderItemDTO.getBrandVehicle());
            orderItemDTO.setRental_day(orderItemDTO.getRental_day());
            orderItemDTO.setStatus(orderItemDTO.getStatus());
            orderItemDTOS.add(orderItemDTO);
        }
        return orderItemDTOS;
    }

    @Override
    public OrderItems setStatusOrderItem(OrderItemDTO orderItemDTO, int idOrder) {
        Optional<OrderItems> orderItemsOptional = Optional.ofNullable(orderRepository.findById(idOrder));
        if (orderItemsOptional.isEmpty()) {
            throw new RuntimeException("OrderItem not found");
        }

        OrderItems item = orderItemsOptional.get();
        item.setStatus(orderItemDTO.getStatus());

        return orderRepository.save(item);
    }


}
