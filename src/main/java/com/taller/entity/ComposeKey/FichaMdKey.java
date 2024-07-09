package com.taller.entity.ComposeKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FichaMdKey implements Serializable {

    private Long codf;
    private Long codmd;
}
