package com.taller.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FichaRequestDto {

    @NotNull(message = "Fecha es requerido")
    private LocalDate fecha;
    @NotNull(message = "Hora es requerido")
    private LocalTime hora;
    @NotNull(message = "Id de vehículo es requerido")
    private Long vehiculoId;
}
