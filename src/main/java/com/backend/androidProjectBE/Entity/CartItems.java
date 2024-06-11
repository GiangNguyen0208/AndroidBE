package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "cart_items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer rental_day;

    private String address;

    private String email;

    private String phone;

    private Date rentalDate;

    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicles;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Carts carts;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rentals rentals;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
