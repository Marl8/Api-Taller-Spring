package com.taller.entity.ComposeKey;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class FichaMdKey implements Serializable {

    private Long codf;
    private Long codmd;
}
