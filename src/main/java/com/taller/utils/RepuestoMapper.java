package com.taller.utils;

import com.taller.dto.request.RepuestoRequestDto;
import com.taller.dto.response.ResponseRepuestoDto;
import com.taller.entity.Repuesto;
import java.util.List;

public class RepuestoMapper {

    public static List<ResponseRepuestoDto> listaRepuestos(List<Repuesto> lista){
        return lista.stream().map(r -> new ResponseRepuestoDto(r.getId(),r.getNombre(),r.getStock(),r.getPp(),
                r.getPrecio(),r.getUnidad())).toList();
    }

    public static ResponseRepuestoDto repuestoDto(Repuesto r){
        ResponseRepuestoDto rep = new ResponseRepuestoDto();
        rep.setId(r.getId());
        rep.setNombre(r.getNombre());
        rep.setPp(r.getPp());
        rep.setStock(r.getStock());
        rep.setPrecio(r.getPrecio());
        rep.setUnidad(r.getUnidad());
        return rep;
    }

    public static Repuesto repuesto(RepuestoRequestDto rDto){
        Repuesto rep = new Repuesto();
        rep.setNombre(rDto.getNombre());
        rep.setPp(rDto.getPp());
        rep.setStock(rDto.getStock());
        rep.setPrecio(rDto.getPrecio());
        rep.setUnidad(rDto.getUnidad());
        return rep;
    }
}
