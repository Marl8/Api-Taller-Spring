package com.taller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteRequestDto {

    @NotBlank(message = "Nombre del cliente es requerido")
    private String nombre;
    @NotBlank(message = "Apellido del cliente es requerido")
    private String apellido;
    @NotBlank(message = "DNI del cliente es requerido")
    private String dni;
    @NotBlank(message = "Dirección del cliente es requerido")
    private String direccion;
    @NotBlank(message = "Teléfono del cliente es requerido")
    private String tel;
}
