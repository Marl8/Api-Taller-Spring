package com.taller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseGetFichaDto {

    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private ResponseVehiculoDto vehiculo;
}
