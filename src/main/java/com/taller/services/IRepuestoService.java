package com.taller.services;

import com.taller.dto.response.RepuestoResponseDto;
import java.util.Set;

public interface IRepuestoService {

    Set<RepuestoResponseDto> findAllRespuestos();

    RepuestoResponseDto findById(Long id);
}
