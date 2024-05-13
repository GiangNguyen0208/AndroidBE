package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;



@Entity(name = "anouces_users")
@Data
public class AnoucesUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int anounceId;

    @Id
    @Column(name = "user_id")
    private String userId;
}
