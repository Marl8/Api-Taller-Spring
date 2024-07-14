package com.taller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseRepuestoDto {

    private Long id;
    private String nombre;
    private int stock;
    private int pp;
    private double precio;
    private String unidad;
}
