package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItems, Integer> {
    CartItems findById(int id);
    void deleteById(int cartItemId);
    List<CartItems> findAllByUsers_Id(int userId);
}
