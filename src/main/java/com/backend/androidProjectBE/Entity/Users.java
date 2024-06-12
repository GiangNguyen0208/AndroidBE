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
    private int id;

    private String username;

    private String firstname;

    private String lastname;

    private Boolean gender;

    private String phone;

    private String email;

    private Date birthDay;

    private Boolean status;

    private String password;

    private String address;

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

    @OneToMany(mappedBy = "users")
    private Set<Carts> carts;

    @OneToMany(mappedBy = "users")
    private Set<CartItems> cartItems;

    @OneToMany(mappedBy = "users")
    private Set<OrderItems> orderItems;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                '}';
    }
}
