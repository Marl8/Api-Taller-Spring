package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "repuesto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codrep")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "stock")
    private int stock;
    @Column(name = "pp")
    private int pp;
    @Column(name = "precio")
    private double precio;
    @Column(name = "Unidad")
    private String unidad;

    @OneToMany(targetEntity = PresuRep.class)
    @JoinColumn(name = "NPresup")
    private Set<PresuRep> presupuestos;
}
