package com.taller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RepuestoRequestDto {

    @NotBlank(message = "Nombre es requerido")
    private String nombre;
    @Positive(message = "Stock debe ser un número positivo")
    private int stock;
    @Positive(message = "PP debe ser un número positivo")
    private int pp;
    @Positive(message = "Precio debe ser un número positivo")
    private double precio;
    @NotBlank(message = "Nombre es requerido")
    private String unidad;
}
