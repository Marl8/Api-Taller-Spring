package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Entity
@Table(name = "mecrep")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MecRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codmr")
    private Long id;

    @Column(name = "hora_E")
    private LocalTime horaEntrada;

    @Column(name = "hora_S")
    private LocalTime horaSalida;

    @ManyToOne
    @JoinColumn(name = "codmec")
    private Mecanico mecanico;
}
