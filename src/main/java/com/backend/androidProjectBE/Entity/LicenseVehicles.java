package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "license_vehicles")
@Data
public class LicenseVehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "number_code")
    private String numberCode;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "birthDay")
    private Date birthDay;

    @Column(name = "rank_license")
    private String rankLicense;

    @Column(name = "imgLicense")
    private String imgLicense;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

}
