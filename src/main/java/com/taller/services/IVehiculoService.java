package com.taller.services;

import com.taller.dto.request.VehiculoRequestDto;
import com.taller.dto.response.ResponseVehiculoDto;

import java.util.Set;

public interface IVehiculoService {

    Set<VehiculoRequestDto> findAllVehiculos();

    ResponseVehiculoDto findById(Long id);
}
