package com.taller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PresupuestoRequestDto {

    @NotNull(message = "Fecha es requerido")
    private LocalDate fecha;
    @NotBlank(message = "DiagFinal es requerido")
    @Size(max = 100)
    private String diagFinal;
    @Positive(message = "monto debe ser un número positivo")
    private double monto;
    @NotNull(message = "Aceptado es requerido")
    private boolean aceptado;
    @NotNull(message = "El id de la ficha es requerido")
    private Long fichaId;
    private Map<Long, Integer> PresuRep;
}
