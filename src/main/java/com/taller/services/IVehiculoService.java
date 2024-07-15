package com.taller.services;

import com.taller.dto.request.VehiculoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseVehiculoDto;
import java.util.Set;

public interface IVehiculoService {

    Set<ResponseVehiculoDto> findAllVehiculos();

    ResponseVehiculoDto findById(Long id);

    ResponseDto save(VehiculoRequestDto vDto);

    ResponseDto updateVehiculos(Long id, VehiculoRequestDto vDto);

    ResponseDto delete(Long id);
}
