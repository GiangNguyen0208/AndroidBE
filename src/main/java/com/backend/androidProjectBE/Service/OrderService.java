package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.*;
import com.backend.androidProjectBE.Repository.CartRepository;
import com.backend.androidProjectBE.Repository.OrderRepository;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Repository.VehiclesRepository;
import com.backend.androidProjectBE.Service.imp.OrderServiceImp;
import com.backend.androidProjectBE.Utils.Constraints;
import com.backend.androidProjectBE.dto.CartItemDTO;
import com.backend.androidProjectBE.dto.OrderDTO;
import com.backend.androidProjectBE.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository  cartRepository;

    @Autowired
    VehiclesRepository vehiclesRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean addOrderItem(CartItemDTO cartItemDTO) {
        Integer vehicleId = cartItemDTO.getVehicleid();
        System.out.println(vehicleId);
        Optional<Vehicles> vehiclesOptional = vehiclesRepository.findById(vehicleId);
        Optional<Users> usersOptional = Optional.ofNullable(userRepository.findById(cartItemDTO.getUserid()));
        // Kiểm tra xem vehiclesOptional có giá trị và usersOptional không rỗng
        if (vehiclesOptional.isPresent() && usersOptional.isPresent()) {
            Vehicles vehicles = vehiclesOptional.get();
            Users users = usersOptional.get();
            // Kiểm tra xem vehicles và users có khớp với cartItemDTO hay không
            if (vehicles.getId() != cartItemDTO.getVehicleid() || users.getId() != cartItemDTO.getUserid()) {
                return false; // Nếu không khớp thì không thêm được vào đơn hàng
            }
            OrderItems orderItem = OrderItems.builder()
                    .vehicles(vehicles)
                    .users(users)
                    .status(Constraints.CONFIRM)
                    .price(cartItemDTO.getPrice())
                    .address(cartItemDTO.getAddress())
                    .email(cartItemDTO.getEmail())
                    .phone(cartItemDTO.getPhone())
                    .rentalDate(cartItemDTO.getRentalDate())
                    .returnDate(cartItemDTO.getReturnDate())
                    .build();
            orderRepository.save(orderItem);
            return true;
        }

        return false;
    }

    @Override
    public List<OrderItemDTO> findAll(int iduser) {
        List<OrderItems> orderItemsList = orderRepository.findAllByUsers_Id(iduser);
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        for (OrderItems items : orderItemsList) {
            Date date1 = items.getRentalDate();
            Date date2 = items.getReturnDate();
            long dayLong = date2.getTime() - date1.getTime();
            long day = TimeUnit.MILLISECONDS.toDays(dayLong);
            int dayInt = (int) day;
            // Tính toán sự khác biệt giữa hai ngày
            OrderItemDTO orderItemDTO = OrderItemDTO.builder()
                    .id(items.getId())
                    .vehicleid(items.getVehicles().getId())
                    .nameVehicle(items.getVehicles().getName())
                    .price(items.getPrice())
                    .brandVehicle(items.getVehicles().getBrands().getName())
                    .rentalDate(items.getRentalDate())
                    .returnDate(items.getReturnDate())
                    .rental_day(dayInt)
                    .phone(items.getPhone())
                    .email(items.getEmail())
                    .address(items.getEmail())
                    .build();
            orderItemDTOS.add(orderItemDTO);
        }
        return orderItemDTOS;
    }

    @Override
    public List<OrderItemDTO> getHistoryOrderContinue(int iduser) {
        List<OrderItems> orderItemsList = orderRepository.findOrderItemsWithReturnDateAfterNow(iduser);
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        for (OrderItems items : orderItemsList) {
            Date date1 = items.getRentalDate();
            Date date2 = items.getReturnDate();
            long dayLong = date2.getTime() - date1.getTime();
            long day = TimeUnit.MILLISECONDS.toDays(dayLong);
            int dayInt = (int) day;
            // Tính toán sự khác biệt giữa hai ngày
            OrderItemDTO orderItemDTO = OrderItemDTO.builder()
                    .id(items.getId())
//                    .vehicleid(items.getVehicles().getId())
                    .nameVehicle(items.getVehicles().getName())
                    .price(items.getPrice())
//                    .brandVehicle(items.getVehicles().getBrands().getName())
                    .rentalDate(items.getRentalDate())
                    .returnDate(items.getReturnDate())
//                    .rental_day(dayInt)
//                    .phone(items.getPhone())
//                    .email(items.getEmail())
//                    .address(items.getEmail())
                    .build();
            orderItemDTOS.add(orderItemDTO);
        }
        return orderItemDTOS;
    }

    @Override
    public List<OrderItemDTO> getHistoryOrderCompleted(int iduser) {
        List<OrderItems> orderItemsList = orderRepository.findOrderItemsWithReturnDateBeforeNow(iduser);
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        for (OrderItems items : orderItemsList) {
            Date date1 = items.getRentalDate();
            Date date2 = items.getReturnDate();
            long dayLong = date2.getTime() - date1.getTime();
            long day = TimeUnit.MILLISECONDS.toDays(dayLong);
            int dayInt = (int) day;
            // Tính toán sự khác biệt giữa hai ngày
            OrderItemDTO orderItemDTO = OrderItemDTO.builder()
                    .id(items.getId())
//                    .vehicleid(items.getVehicles().getId())
                    .nameVehicle(items.getVehicles().getName())
                    .price(items.getPrice())
//                    .brandVehicle(items.getVehicles().getBrands().getName())
                    .rentalDate(items.getRentalDate())
                    .returnDate(items.getReturnDate())
//                    .rental_day(dayInt)
//                    .phone(items.getPhone())
//                    .email(items.getEmail())
//                    .address(items.getEmail())
                    .build();
            orderItemDTOS.add(orderItemDTO);
        }
        return orderItemDTOS;
    }

    @Override
    public void removeOrderItem(int id) {
        orderRepository.deleteById(id);
    }


    // Thanh toan
    @Override
    public OrderItemDTO getCartItemToPay(int cartItemId) {
        CartItems cartItems = cartRepository.findById(cartItemId);

        OrderItemDTO orderItemDTO = OrderItemDTO.builder()
                .vehicleid(cartItems.getVehicles().getId())
                .nameVehicle(cartItems.getVehicles().getName())
                .brandVehicle(cartItems.getVehicles().getBrands().getName())
                .imageLink(cartItems.getVehicles().getImages().getImgLink())
                .rentalDate(cartItems.getRentals().getRentalDate())
                .returnDate(cartItems.getRentals().getReturnDate())
                .rental_day(cartItems.getRental_day())
                .address(cartItems.getAddress())
                .phone(cartItems.getPhone())
                .email(cartItems.getEmail())
                .build();
        return orderItemDTO;
    }

    @Override
    public OrderItemDTO getDetail(int idOrderItem) {
        OrderItems orderItems = orderRepository.findById(idOrderItem);
            Date date1 = orderItems.getRentalDate();
            Date date2 = orderItems.getReturnDate();
            long dayLong = date2.getTime() - date1.getTime();
            long day = TimeUnit.MILLISECONDS.toDays(dayLong);
            int dayInt = (int) day;
            // Tính toán sự khác biệt giữa hai ngày
            OrderItemDTO orderItemDTO = OrderItemDTO.builder()
                    .id(orderItems.getId())
                    .vehicleid(orderItems.getVehicles().getId())
                    .nameVehicle(orderItems.getVehicles().getName())
                    .price(orderItems.getPrice())
                    .brandVehicle(orderItems.getVehicles().getBrands().getName())
                    .rentalDate(orderItems.getRentalDate())
                    .returnDate(orderItems.getReturnDate())
                    .rental_day(dayInt)
                    .phone(orderItems.getPhone())
                    .email(orderItems.getEmail())
                    .address(orderItems.getEmail())
                    .build();
        return orderItemDTO;
    }
}
