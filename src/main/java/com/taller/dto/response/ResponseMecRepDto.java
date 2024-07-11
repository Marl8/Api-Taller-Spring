package com.taller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseMecRepDto {

    private Long id;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private Long idMecanico;
}
