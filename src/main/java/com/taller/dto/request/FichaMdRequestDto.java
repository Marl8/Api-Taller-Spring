package com.taller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FichaMdRequestDto {

    @NotBlank(message = "Informe es Requerido")
    @Size(max = 100)
    String informe;
}
