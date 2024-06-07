package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity(name = "payments")
@Data
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date dateCreate;

    @OneToMany(mappedBy = "payments")
    private Set<Orders> orderPayment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Cards cards;

}
