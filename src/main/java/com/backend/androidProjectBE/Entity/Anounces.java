package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "anounces")
@Data
public class Anounces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private Date sendAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}