package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.OrderItems;
import com.backend.androidProjectBE.Entity.Orders;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderItems, Integer> {
    List<OrderItems> findAllByUsers_Id(int idUser);
}
