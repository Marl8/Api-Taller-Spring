package com.taller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoRequestDto {

    private Long id;
    private String matricula;
    private String modelo;
    private String marca;
    private String color;
    private Long idCliente;
}
