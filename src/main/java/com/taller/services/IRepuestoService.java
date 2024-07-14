package com.taller.services;

import com.taller.dto.request.RepuestoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseRepuestoDto;
import java.util.Set;

public interface IRepuestoService {

    Set<ResponseRepuestoDto> findAllRespuestos();

    ResponseRepuestoDto findById(Long id);

    ResponseDto save(RepuestoRequestDto rDto);

    ResponseDto update(RepuestoRequestDto r, Long id);

    ResponseDto delete(Long id);
}
