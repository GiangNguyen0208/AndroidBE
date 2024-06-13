package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double price;

    private String address;

    private String name;

    private String email;

    private String phone;

    private Date rentalDate;

    private Date returnDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicles;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
