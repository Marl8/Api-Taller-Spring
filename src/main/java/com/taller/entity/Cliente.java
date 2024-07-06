package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codC")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private String dni;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "tel")
    private String tel;

    @OneToMany(mappedBy = "cliente")
    Set<Vehiculo> vehiculos;
}
