package com.taller.utils;

import com.taller.dto.request.VehiculoRequestDto;
import com.taller.dto.response.ResponseVehiculoDto;
import com.taller.entity.Vehiculo;

import java.util.List;

public class VehiculoMapper {

    public static List<VehiculoRequestDto> listaVehiculos(List<Vehiculo> vehiculos){
        return vehiculos.stream().map(v -> new VehiculoRequestDto(v.getMatricula(),v.getModelo(),v.getMarca(),
                v.getColor(),v.getCliente().getId())).toList();
    }

    public static ResponseVehiculoDto vehiculoDto(Vehiculo v){
        ResponseVehiculoDto veh = new ResponseVehiculoDto();
        veh.setId(v.getId());
        veh.setMatricula(v.getMatricula());
        veh.setModelo(v.getModelo());
        veh.setMarca(v.getMarca());
        veh.setColor(v.getColor());
        veh.setIdCliente(v.getCliente().getId());
        return veh;
    }
}
