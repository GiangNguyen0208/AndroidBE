package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Orders;
import com.backend.androidProjectBE.Entity.Users;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderItems, Integer> {
    OrderItems findById(int id);
}
