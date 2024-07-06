package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "ficha")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="codF")
    private Long id;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "hora")
    private LocalTime hora;

    @OneToMany(mappedBy = "ficha")
    Set<Presupuesto> presupuestos;

    @ManyToOne
    @JoinColumn(name = "codVeh")
    private Vehiculo vehiculo;
}
