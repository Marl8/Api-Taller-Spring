package com.taller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseMecDiagDto {

    private Long id;
    private String tematica;
    private Long idMecanico;
}
