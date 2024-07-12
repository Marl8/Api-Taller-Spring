package com.taller.services;

import com.taller.dto.response.ResponsePresupuestoDto;

import java.util.Set;

public interface IPresupuestoService {

    Set<ResponsePresupuestoDto> findAll();

    ResponsePresupuestoDto findById(Long id);
}
