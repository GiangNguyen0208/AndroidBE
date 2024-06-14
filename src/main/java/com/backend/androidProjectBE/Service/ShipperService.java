package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.OrderRepository;
import com.backend.androidProjectBE.Service.imp.ShipperServiceImp;
import com.backend.androidProjectBE.dto.OrderItemDTO;
import com.backend.androidProjectBE.dto.UserDTO;
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
            orderItemDTO.setVehicleid(orderItem.getVehicles().getId());
            orderItemDTO.setBrandVehicle(orderItem.getVehicles().getBrands().getName());
            orderItemDTO.setImageLink(orderItem.getVehicles().getImages().getImgLink());
            orderItemDTO.setNameVehicle(String.valueOf(orderItem.getVehicles().getName()));
            orderItemDTO.setRentalDate(orderItem.getRentalDate());
            orderItemDTO.setReturnDate(orderItem.getReturnDate());
            orderItemDTO.setRental_day(orderItem.getRentalDay());
            orderItemDTO.setStatus(orderItem.getStatus());
            orderItemDTOS.add(orderItemDTO);
        }
        return orderItemDTOS;
    }

    @Override
    public OrderItemDTO findOrderItemById(int id) {
        Optional<OrderItems> orderItemOptional = Optional.ofNullable(orderRepository.findById(id));
        if (orderItemOptional.isPresent()) {
            OrderItems item = orderItemOptional.get();
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setPhone(item.getPhone());
            orderItemDTO.setAddress(item.getAddress());
            orderItemDTO.setVehicleid(item.getVehicles().getId());
            orderItemDTO.setStatus(item.getStatus());
            orderItemDTO.setRentalDate(item.getRentalDate());
            orderItemDTO.setImageLink(item.getVehicles().getImages().getImgLink());

            return orderItemDTO;
        } else {
            throw new RuntimeException("Order Lord");
        }
    }

    @Override
    public OrderItemDTO setStatusOrderItem(OrderItemDTO orderItemDTO, int idOrder) {
        Optional<OrderItems> orderItemsOptional = Optional.ofNullable(orderRepository.findById(idOrder));
        if (orderItemsOptional.isEmpty()) {
            throw new RuntimeException("OrderItem not found");
        }
        OrderItems item = orderItemsOptional.get();
        item.setStatus(orderItemDTO.getStatus());
        item = orderRepository.save(item);
        OrderItemDTO orderItemDTOmini = new OrderItemDTO();
        orderItemDTOmini.setPhone(item.getPhone());
        orderItemDTOmini.setAddress(item.getAddress());
        orderItemDTOmini.setVehicleid(item.getVehicles().getId());
        orderItemDTOmini.setStatus(item.getStatus());
        orderItemDTOmini.setRentalDate(item.getRentalDate());
        orderItemDTOmini.setImageLink(item.getVehicles().getImages().getImgLink());

        return orderItemDTOmini;
    }


}
