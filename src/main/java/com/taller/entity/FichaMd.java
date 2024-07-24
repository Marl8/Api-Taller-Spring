package com.taller.entity;

import com.taller.entity.ComposeKey.FichaMdKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fichamd")
@IdClass(FichaMdKey.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FichaMd {

    @Id
    @Column(name = "codF")
    private Long codf;

    @Id
    @Column(name = "codmd")
    private Long codmd;

    @Column(name = "informe")
    private String informe;

}
