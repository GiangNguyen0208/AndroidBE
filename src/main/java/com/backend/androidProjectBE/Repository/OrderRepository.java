package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Orders;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.dto.OrderDTO;
import com.backend.androidProjectBE.dto.OrderItemDTO;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    List<OrderDTO> findByUsers(Users user);

}
