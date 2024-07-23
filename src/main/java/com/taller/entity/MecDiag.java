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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codmd")
    private Long id;

    @Column(name = "tematica")
    private String tematica;

    @ManyToOne
    @JoinColumn(name = "codmec", referencedColumnName= "codmec")
    private Mecanico mecanico;

    @OneToMany
    @JoinColumn(name = "codmd")
    private Set<FichaMd> fichasMd;
}
