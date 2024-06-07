package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity(name = "license_vehicles")
@Data
public class LicenseVehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numberCode;

    private String fullname;

    private Date birthDay;

    private String rankLicense;

    private String imgLicense;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

}
