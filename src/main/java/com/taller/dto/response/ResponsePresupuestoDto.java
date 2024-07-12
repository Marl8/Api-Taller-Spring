package com.taller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePresupuestoDto {

    private Long id;
    private LocalDate fecha;
    private String diagFinal;
    private double monto;
    private boolean aceptado;
    private Long fichaId;
}
