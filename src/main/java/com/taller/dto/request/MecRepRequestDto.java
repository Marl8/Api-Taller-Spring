package com.taller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MecRepRequestDto {

    @NotNull(message = "Hora de entrada es requerido")
    private LocalTime horaEntrada;
    @NotNull(message = "Hora de salida es requerido")
    private LocalTime horaSalida;
    @NotNull(message = "Id del mecánico es requerido")
    @Positive(message = "Id del mecánico debe ser un número positivo")
    private Long idMecanico;
}
