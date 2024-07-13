package com.taller.utils;

import com.taller.dto.response.RepuestoResponseDto;
import com.taller.entity.Repuesto;
import org.apache.tomcat.util.http.ResponseUtil;

import java.util.List;

public class RepuestoMapper {

    public static List<RepuestoResponseDto> listaRepuestos(List<Repuesto> lista){
        return lista.stream().map(r -> new RepuestoResponseDto(r.getId(),r.getNombre(),r.getStock(),r.getPp(),
                r.getPrecio(),r.getUnidad())).toList();
    }

    public static RepuestoResponseDto repuestoDto(Repuesto r){
        RepuestoResponseDto rep = new RepuestoResponseDto();
        rep.setId(r.getId());
        rep.setNombre(r.getNombre());
        rep.setPp(r.getPp());
        rep.setStock(r.getStock());
        rep.setPrecio(r.getPrecio());
        rep.setUnidad(r.getUnidad());
        return rep;
    }
}
