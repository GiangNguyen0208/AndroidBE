package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity(name = "license_vehicles")
@Data
public class LicenseVehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "imgLicense")
    private String imgLicense;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
