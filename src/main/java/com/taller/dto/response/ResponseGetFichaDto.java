package com.taller.dto.response;

import com.taller.dto.request.VehiculoRequestDto;
import com.taller.entity.Vehiculo;
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
    private VehiculoRequestDto vehiculo;
}
