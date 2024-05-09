package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date_create")
    private Date dateCreate;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rentals rentals;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payments payments;
}
