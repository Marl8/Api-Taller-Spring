package com.taller.dto.request;

import jakarta.validation.constraints.NotNull;
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
    private Long idMecanico;
}
