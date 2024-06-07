package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Entity(name = "carts")
@Data
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(mappedBy = "carts")
    Set<CartItems> carts;

}
