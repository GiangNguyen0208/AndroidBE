package com.backend.androidProjectBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name = "colors")
@Data
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "codeColor")
    private String codeColor;

    @Column(name = "nameColor")
    private String nameColor;

    @OneToMany(mappedBy = "colors")
    private Set<Vehicles> listColor;

}
