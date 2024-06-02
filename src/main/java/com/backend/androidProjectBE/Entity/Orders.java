package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity(name = "orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @OneToMany(mappedBy = "orders")
    private Set<OrderItems> orderItems;
}
