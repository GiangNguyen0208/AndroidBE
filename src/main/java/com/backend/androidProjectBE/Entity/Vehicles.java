package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity(name = "vehicles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String type;

    private Boolean status;

    private Double price;

    private String about;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discounts discounts;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Colors colors;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brands brands;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Models models;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Images images;

    @OneToMany(mappedBy = "vehicles")
    private Set<Rates> rateVehicles;

    @OneToMany(mappedBy = "vehicles")
    private Set<Rentals> rentalVehicles;

    @OneToMany(mappedBy = "vehicles")
    private Set<OrderItems> orderItems;

    @OneToMany(mappedBy = "vehicles")
    private Set<CartItems> cartItems;

    public Vehicles(int id) {
        this.images = new Images();
    }
}
