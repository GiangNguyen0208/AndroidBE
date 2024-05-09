package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name = "images")
@Data
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "imgLink")
    private String imgLink;

    @OneToMany(mappedBy = "images")
    private Set<Vehicles> listImg;
}
