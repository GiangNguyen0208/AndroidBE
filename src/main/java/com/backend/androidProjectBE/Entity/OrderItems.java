package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double price;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicles;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
}
