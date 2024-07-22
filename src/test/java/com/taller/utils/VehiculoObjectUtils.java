package com.taller.utils;

import com.taller.dto.request.VehiculoRequestDto;
import com.taller.dto.response.ResponseVehiculoDto;
import com.taller.entity.Vehiculo;

import java.util.List;
import java.util.Set;

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

    public static Vehiculo vehiculo2(){
        Vehiculo v = new Vehiculo();
        v.setId(1L);
        v.setMatricula("FGJ392");
        v.setMarca("Ford");
        v.setModelo("Fiesta");
        v.setColor("Azul");
        v.setCliente(ClienteObjectUtils.cliente2());
        return v;
    }


    public static ResponseVehiculoDto vehiculoDto(){
        ResponseVehiculoDto v = new ResponseVehiculoDto();
        v.setId(1L);
        v.setMatricula("AFG325");
        v.setMarca("Fiat");
        v.setModelo("Cronos");
        v.setColor("Gris");
        v.setIdCliente(ClienteObjectUtils.cliente1().getId());
        return v;
    }

    public static ResponseVehiculoDto vehiculoDto2(){
        ResponseVehiculoDto v = new ResponseVehiculoDto();
        v.setId(1L);
        v.setMatricula("FGJ392");
        v.setMarca("Ford");
        v.setModelo("Fiesta");
        v.setColor("Azul");
        v.setIdCliente(ClienteObjectUtils.cliente2().getId());
        return v;
    }

    public static List<Vehiculo> lista(){
        return List.of(vehiculo(),vehiculo2());
    }

    public static Set<ResponseVehiculoDto> listaDto(){
        return Set.of(vehiculoDto(),vehiculoDto2());
    }

    public static VehiculoRequestDto vehiculoReqDto(){
        VehiculoRequestDto v = new VehiculoRequestDto();
        v.setMatricula("AFG325");
        v.setMarca("Fiat");
        v.setModelo("Cronos");
        v.setColor("Gris");
        v.setIdCliente(ClienteObjectUtils.cliente1().getId());
        return v;
    }
}
