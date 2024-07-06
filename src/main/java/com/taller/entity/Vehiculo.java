package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "vehiculo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codVeh")
    private Long id;

    @Column(name = "matricula")
    private String matricula;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "marca")
    private String marca;
    @Column(name = "color")
    private String color;

    @OneToMany(mappedBy = "vehiculo")
    private Set<Ficha> fichas;

    @ManyToOne
    @JoinColumn(name = "codC")
    private Cliente cliente;
}
