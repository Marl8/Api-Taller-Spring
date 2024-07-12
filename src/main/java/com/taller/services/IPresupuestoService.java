package com.taller.services;

import com.taller.dto.request.PresupuestoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponsePresupuestoDto;

import java.util.Set;

public interface IPresupuestoService {

    Set<ResponsePresupuestoDto> findAll();

    ResponsePresupuestoDto findById(Long id);

    ResponseDto save(PresupuestoRequestDto p);
}
