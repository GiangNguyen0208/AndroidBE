package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity(name = "rentals")
@Data
public class Rentals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date rentalDate;

    private Date returnDate;

    // location

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicles;

    @OneToMany(mappedBy = "rentals")
    private Set<Orders> orderRental;

    @OneToMany(mappedBy = "rentals")
    private Set<CartItems> cartItems;

}
