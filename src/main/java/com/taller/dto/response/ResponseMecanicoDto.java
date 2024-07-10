package com.taller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseMecanicoDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String tel;
    private boolean repara;
}
