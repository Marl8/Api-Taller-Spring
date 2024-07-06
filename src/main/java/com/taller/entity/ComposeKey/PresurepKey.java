package com.taller.entity.ComposeKey;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class PresurepKey implements Serializable {

    private Long NPresurep;
    private Long codrep;

    /*
    * Compose Key
    *
    * https://www.baeldung.com/jpa-composite-primary-keys
    * */
}
