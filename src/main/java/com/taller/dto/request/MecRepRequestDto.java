package com.taller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MecRepRequestDto {

    @NotBlank(message = "Hora de entrada es requerido")
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])$", message = "Formato incorrecto")
    private String horaEntrada;
    @NotBlank(message = "Hora de salida es requerido")
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])$", message = "Formato incorrecto")
    private String horaSalida;
    @NotNull(message = "Id del mecánico es requerido")
    @Positive(message = "Id del mecánico debe ser un número positivo")
    private Long idMecanico;
}
