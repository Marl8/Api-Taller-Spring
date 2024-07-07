package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "mecdiag")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MecDiag {

    @Id
    @Column(name = "codmd")
    private Long id;

    @Column(name = "tematica")
    private String tematica;
    //private Mecanico mecanico;

    @OneToMany(mappedBy = "mecDiag")
    private Set<FichaMd> fichasMd;
}
