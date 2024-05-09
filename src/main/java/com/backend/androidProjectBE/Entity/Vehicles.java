package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity(name = "vehicles")
@Data
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "price")
    private Double price;

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
}
