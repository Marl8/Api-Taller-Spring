package com.taller.utils;

import com.taller.dto.request.FichaRequestDto;
import com.taller.dto.request.VehiculoRequestDto;
import com.taller.dto.response.ResponseGetFichaDto;
import com.taller.entity.Ficha;

public class FichaMapper {

    public static ResponseGetFichaDto getFicha(Ficha ficha) {
        VehiculoRequestDto vehiculo = new VehiculoRequestDto();
        vehiculo.setId(ficha.getVehiculo().getId());
        vehiculo.setMarca(ficha.getVehiculo().getMarca());
        vehiculo.setModelo(ficha.getVehiculo().getModelo());
        vehiculo.setMatricula(ficha.getVehiculo().getMatricula());
        vehiculo.setColor(ficha.getVehiculo().getColor());
        vehiculo.setIdCliente(ficha.getVehiculo().getCliente().getId());
        return new ResponseGetFichaDto(ficha.getId(),ficha.getFecha(),ficha.getHora(),vehiculo);
    }

    public static Ficha ficha(FichaRequestDto fichaDto) {
        Ficha ficha = new Ficha();
        ficha.setFecha(fichaDto.getFecha());
        ficha.setHora(fichaDto.getHora());
        return ficha;
    }
}
