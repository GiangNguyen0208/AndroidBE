package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name = "colors")
@Data
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codeColor;

    private String nameColor;

    @OneToMany(mappedBy = "colors")
    private Set<Vehicles> listColor;

}
