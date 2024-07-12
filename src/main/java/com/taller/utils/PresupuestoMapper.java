package com.taller.utils;

import com.taller.dto.request.PresupuestoRequestDto;
import com.taller.dto.response.ResponsePresupuestoDto;
import com.taller.entity.Presupuesto;
import java.util.List;

public class PresupuestoMapper {

    public static List<ResponsePresupuestoDto> findAll(List<Presupuesto> presup){
        return presup.stream().map(p -> new ResponsePresupuestoDto(p.getId(),p.getFecha(), p.getDiagFinal(),
                p.getMonto(),p.isAceptado(),p.getFicha().getId())).toList();
    }

    public static ResponsePresupuestoDto responseDto(Presupuesto p){
        ResponsePresupuestoDto res = new ResponsePresupuestoDto();
        res.setId(p.getId());
        res.setFecha(p.getFecha());
        res.setDiagFinal(p.getDiagFinal());
        res.setMonto(p.getMonto());
        res.setAceptado(p.isAceptado());
        res.setFichaId(p.getFicha().getId());
        return res;
    }

    public static Presupuesto presupuesto(PresupuestoRequestDto p) {
        Presupuesto res = new Presupuesto();
        res.setFecha(p.getFecha());
        res.setDiagFinal(p.getDiagFinal());
        res.setMonto(p.getMonto());
        res.setAceptado(p.isAceptado());
        return res;
    }
}
