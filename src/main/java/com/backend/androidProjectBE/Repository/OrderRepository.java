package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderItems, Integer> {
    List<OrderItems> findAllByUsers_Id(int idUser);
    OrderItems findById(int id);
    @Query(value = "SELECT * FROM order_items WHERE user_id = :idUser AND  return_date > CURRENT_DATE", nativeQuery = true)
    List<OrderItems> findOrderItemsWithReturnDateAfterNow(int idUser);
    @Query(value = "SELECT * FROM order_items WHERE user_id = :idUser AND  return_date < CURRENT_DATE", nativeQuery = true)
    List<OrderItems> findOrderItemsWithReturnDateBeforeNow(int idUser);
}
