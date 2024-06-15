package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Orders;
import com.backend.androidProjectBE.dto.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

    List<OrderItems> findByOrders(Orders order);
}
