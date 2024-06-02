package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "cart_items")
@Data
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer rental_day;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicles;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Carts carts;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rentals rentals;
    public CartItems() {
        this.vehicles = new Vehicles(); // Khởi tạo đối tượng Vehicles trong constructor
        this.rentals = new Rentals(); // Khởi tạo đối tượng Rentals trong constructor
    }
}
