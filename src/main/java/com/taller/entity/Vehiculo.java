package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "vehiculo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codveh")
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
    @JoinColumn(name = "codC", referencedColumnName = "codC")
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(id, vehiculo.id) && Objects.equals(matricula, vehiculo.matricula)
                && Objects.equals(modelo, vehiculo.modelo) && Objects.equals(marca, vehiculo.marca)
                && Objects.equals(color, vehiculo.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matricula, modelo, marca, color);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "color='" + color + '\'' +
                ", cliente=" + cliente +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", id=" + id +
                '}';
    }
}
