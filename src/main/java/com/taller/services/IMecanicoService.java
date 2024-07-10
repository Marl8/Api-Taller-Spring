package com.taller.services;

import com.taller.dto.request.MecanicoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseMecanicoDto;
import com.taller.entity.Mecanico;

import java.util.Set;

public interface IMecanicoService {

    Set<Mecanico> findAllMecanicos();

    ResponseMecanicoDto findMecanicoById(Long id);

    ResponseDto saveMecanico(MecanicoRequestDto mecanicoDto);

    ResponseDto updateMecanico(Long id, MecanicoRequestDto mecanicoDto);

    ResponseDto deleteMecanico(Long id);
}
