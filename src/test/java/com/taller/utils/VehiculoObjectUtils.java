package com.taller.utils;

import com.taller.dto.response.ResponseVehiculoDto;
import com.taller.entity.Vehiculo;

public class VehiculoObjectUtils {

    public static Vehiculo vehiculo(){
        Vehiculo v = new Vehiculo();
        v.setId(1L);
        v.setMatricula("AFG325");
        v.setMarca("Fiat");
        v.setModelo("Cronos");
        v.setColor("Gris");
        v.setCliente(ClienteObjectUtils.cliente1());
    return v;
    }

    public static ResponseVehiculoDto vehiculoGetDto(){
        ResponseVehiculoDto v = new ResponseVehiculoDto();
        v.setId(1L);
        v.setMatricula("AFG325");
        v.setMarca("Fiat");
        v.setModelo("Cronos");
        v.setColor("Gris");
        v.setIdCliente(ClienteObjectUtils.cliente1().getId());
        return v;
    }
}
