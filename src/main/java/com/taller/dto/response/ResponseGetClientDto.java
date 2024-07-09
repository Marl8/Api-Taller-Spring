package com.taller.dto.response;

import com.taller.dto.request.VehiculoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseGetClientDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String tel;
    private Set<VehiculoRequestDto> vehiculos;
}
