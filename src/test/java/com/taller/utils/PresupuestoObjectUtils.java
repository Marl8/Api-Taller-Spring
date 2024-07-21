package com.taller.utils;

import com.taller.dto.request.PresupuestoRequestDto;
import com.taller.dto.response.ResponsePresupuestoDto;
import com.taller.entity.Presupuesto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PresupuestoObjectUtils {

    public static Presupuesto presupuesto(){
        Presupuesto pre = new Presupuesto();
        pre.setId(1L);
        pre.setFicha(FichaObjectsUtils.ficha());
        pre.setFecha(LocalDate.now());
        pre.setMonto(198500);
        pre.setDiagFinal("Cambio de carburador");
        pre.setAceptado(true);
        return pre;
    }

    public static Presupuesto presupuesto2(){
        Presupuesto pre = new Presupuesto();
        pre.setId(2L);
        pre.setFicha(FichaObjectsUtils.ficha());
        pre.setFecha(LocalDate.now());
        pre.setMonto(257000);
        pre.setDiagFinal("Cambio de pastillas de freno");
        pre.setAceptado(false);
        return pre;
    }

    public static ResponsePresupuestoDto presupuestoDto1(){
        ResponsePresupuestoDto pre = new ResponsePresupuestoDto();
        pre.setId(1L);
        pre.setFichaId(FichaObjectsUtils.ficha().getId());
        pre.setFecha(LocalDate.now());
        pre.setMonto(198500);
        pre.setDiagFinal("Cambio de carburador");
        pre.setAceptado(true);
        return pre;
    }

    public static ResponsePresupuestoDto presupuestoDto2(){
        ResponsePresupuestoDto pre = new ResponsePresupuestoDto();
        pre.setId(2L);
        pre.setFichaId(FichaObjectsUtils.ficha().getId());
        pre.setFecha(LocalDate.now());
        pre.setMonto(257000);
        pre.setDiagFinal("Cambio de pastillas de freno");
        pre.setAceptado(false);
        return pre;
    }

    public static List<Presupuesto> lista(){
        return List.of(presupuesto(), presupuesto2());
    }

    public static Set<ResponsePresupuestoDto> listaDto(){
        return Set.of(presupuestoDto1(), presupuestoDto2());
    }

    public static PresupuestoRequestDto presupuestoReqDto(){
        PresupuestoRequestDto pre = new PresupuestoRequestDto();
        pre.setFichaId(FichaObjectsUtils.ficha().getId());
        pre.setFecha(LocalDate.now());
        pre.setMonto(198500);
        pre.setDiagFinal("Cambio de carburador");
        pre.setAceptado(true);
        Map<Long, Integer> mapa = new HashMap<>();
        mapa.put(1L,1);
        mapa.put(2L, 2);
        pre.setPresuRep(mapa);
        return pre;
    }

    public static PresupuestoRequestDto presupuestoReqDto2(){
        PresupuestoRequestDto pre = new PresupuestoRequestDto();
        pre.setFichaId(FichaObjectsUtils.ficha().getId());
        pre.setFecha(LocalDate.now());
        pre.setMonto(198500);
        pre.setDiagFinal("Cambio de carburador");
        pre.setAceptado(true);
        Map<Long, Integer> mapa = new HashMap<>();
        mapa.put(1L,1);
        mapa.put(2L, 2);
        pre.setPresuRep(mapa);
        return pre;
    }
}
