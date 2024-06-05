package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity(name = "payments")
@Data
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date_create")
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
