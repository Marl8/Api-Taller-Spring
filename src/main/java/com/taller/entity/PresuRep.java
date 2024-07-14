package com.taller.entity;

import com.taller.entity.ComposeKey.PresurepKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "presurep")
@IdClass(PresurepKey.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PresuRep {

    @Id
    @Column(name = "NPresup")
    private Long NPresup;

    @Id
    @Column(name = "codrep")
    private Long codrep;

    @Column(name = "cant")
    private int cantidad;
}
