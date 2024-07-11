package com.taller.services;

import com.taller.dto.request.MecanicoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseMecanicoDto;

import java.util.Set;

public interface IMecanicoService {

    Set<ResponseMecanicoDto> findAllMecanicos();

    ResponseMecanicoDto findMecanicoById(Long id);

    ResponseDto saveMecanico(MecanicoRequestDto mecanicoDto);

    ResponseDto updateMecanico(Long id, MecanicoRequestDto mecanicoDto);

    ResponseDto deleteMecanico(Long id);
}
