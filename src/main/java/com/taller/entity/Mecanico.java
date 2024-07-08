package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mecanico")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codmec")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "tel")
    private String tel;
    @Column(name = "repara")
    private boolean repara;
}
