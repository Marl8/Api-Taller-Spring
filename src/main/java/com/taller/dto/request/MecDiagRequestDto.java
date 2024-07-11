package com.taller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MecDiagRequestDto {

    @NotBlank(message = "Temática es requerido")
    private String tematica;
    @NotNull(message = "IdMecanico es requerido")
    private Long idMecanico;
}
