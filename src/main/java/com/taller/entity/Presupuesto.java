package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "presup")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Presupuesto {

    @Column(name = "NPresup")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "diagfinal")
    private String diagFinal;
    @Column(name = "monto")
    private double monto;
    @Column(name = "aceptado")
    private boolean aceptado;
    @ManyToOne
    @JoinColumn(name = "codf")
    private Ficha ficha;

    @ManyToMany
    @JoinTable(name = "presurep", joinColumns = @JoinColumn(name = "NPresup"),
            inverseJoinColumns = @JoinColumn(name = "codrep"))
    private Set<Repuesto> repuestos = new HashSet<>();
}
