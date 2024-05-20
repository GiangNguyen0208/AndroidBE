package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity(name = "users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "email")
    private String email;

    @Column(name = "birthDay")
    private Date birthDay;

    @Column(name = "role")
    private Boolean role;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<Anounces> listUserAnounce;

    @OneToMany(mappedBy = "users")
    private Set<LicenseVehicles> listLicenseVehicles;

    @OneToMany(mappedBy = "users")
    private Set<Orders> orderUser;

    @OneToMany(mappedBy = "users")
    private Set<Payments> paymentUser;

    @OneToMany(mappedBy = "users")
    private Set<Rates> rateUser;

}
