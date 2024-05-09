package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name = "discounts")
@Data
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "value")
    private Double value;

    @OneToMany(mappedBy = "discounts")
    private Set<Vehicles> listDiscount;
}
