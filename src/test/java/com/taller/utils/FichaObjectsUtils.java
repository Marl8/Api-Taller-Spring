package com.taller.utils;

import com.taller.dto.request.FichaRequestDto;
import com.taller.dto.response.ResponseGetFichaDto;
import com.taller.entity.Ficha;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class FichaObjectsUtils {

    public static Ficha ficha(){
        Ficha f = new Ficha();
        f.setId(1L);
        f.setHora(LocalTime.of(11,50,18));
        f.setFecha(LocalDate.now());
        f.setVehiculo(VehiculoObjectUtils.vehiculo());
        return f;
    }

    public static Ficha ficha2(){
        Ficha f = new Ficha();
        f.setId(2L);
        f.setHora(LocalTime.of(8,23,36));
        f.setFecha(LocalDate.now());
        f.setVehiculo(VehiculoObjectUtils.vehiculo2());
        return f;
    }

    public static ResponseGetFichaDto fichaDto(){
        ResponseGetFichaDto f = new ResponseGetFichaDto();
        f.setId(1L);
        f.setHora(LocalTime.of(11,50,18));
        f.setFecha(LocalDate.now());
        f.setVehiculo(VehiculoObjectUtils.vehiculoDto());
        return f;
    }

    public static FichaRequestDto fichaRequestDto(){
        FichaRequestDto f = new FichaRequestDto();
        f.setHora(LocalTime.of(11,50,18));
        f.setFecha(LocalDate.now());
        f.setVehiculoId(VehiculoObjectUtils.vehiculo().getId());
        return f;
    }
}
