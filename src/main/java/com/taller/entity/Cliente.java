package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Objects;
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

    @OneToMany(mappedBy = "cliente", targetEntity = Vehiculo.class)
    Set<Vehiculo> vehiculos = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido,
                cliente.apellido) && Objects.equals(dni, cliente.dni) && Objects.equals(direccion, cliente.direccion)
                && Objects.equals(tel, cliente.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni, direccion, tel, vehiculos);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "tel='" + tel + '\'' +
                ", direccion='" + direccion + '\'' +
                ", dni='" + dni + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}

