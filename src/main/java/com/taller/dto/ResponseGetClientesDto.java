package com.taller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseGetClientesDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String tel;
}
