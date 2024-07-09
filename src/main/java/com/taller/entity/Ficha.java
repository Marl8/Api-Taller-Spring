package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
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
    @JoinColumn(name = "codveh")
    private Vehiculo vehiculo;

    @OneToMany(mappedBy = "ficha")
    private Set<FichaMd> fichasMd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ficha ficha = (Ficha) o;
        return Objects.equals(id, ficha.id) && Objects.equals(fecha, ficha.fecha) && Objects.equals(hora, ficha.hora)
                && Objects.equals(fichasMd, ficha.fichasMd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, hora, fichasMd);
    }

    @Override
    public String toString() {
        return "Ficha{" +
                "vehiculo=" + vehiculo +
                ", presupuestos=" + presupuestos +
                ", hora=" + hora +
                ", fecha=" + fecha +
                ", id=" + id +
                '}';
    }
}

