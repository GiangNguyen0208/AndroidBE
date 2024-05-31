package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity(name = "vehicles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    private Boolean status;

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
