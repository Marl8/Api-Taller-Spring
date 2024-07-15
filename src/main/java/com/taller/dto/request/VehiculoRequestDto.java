package com.taller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoRequestDto {

    @NotBlank(message = "Matrícula es requerido")
    private String matricula;
    @NotBlank(message = "Modelo es requerido")
    private String modelo;
    @NotBlank(message = "Marca es requerido")
    private String marca;
    @NotBlank(message = "Color es requerido")
    private String color;
    @Positive(message = "Id de cliente debe ser un número positivo")
    private Long idCliente;
}
