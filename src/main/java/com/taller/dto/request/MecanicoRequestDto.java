package com.taller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MecanicoRequestDto {

    @NotBlank(message = "Nombre es requerido")
    private String nombre;
    @NotBlank(message = "Apellido es requerido")
    private String apellido;
    @NotBlank(message = "DNI es requerido")
    private String dni;
    @NotBlank(message = "Teléfono es requerido")
    private String tel;
    @NotNull(message = "Nombre es requerido")
    private boolean repara;
}
