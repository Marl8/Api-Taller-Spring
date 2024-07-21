package com.taller.utils;

import com.taller.dto.request.RepuestoRequestDto;
import com.taller.dto.response.ResponseRepuestoDto;
import com.taller.entity.Repuesto;

import java.util.List;
import java.util.Set;

public class RepuestoObjectUtils {

    public static Repuesto repuesto(){
        Repuesto r = new Repuesto();
        r.setId(1L);
        r.setNombre("Amortiguador trasero");
        r.setStock(8);
        r.setPrecio(27800);
        r.setPp(6);
        r.setUnidad("Por unidad");
        return r;
    }

    public static Repuesto repuesto2(){
        Repuesto r = new Repuesto();
        r.setId(2L);
        r.setNombre("Amortiguador delantero");
        r.setStock(10);
        r.setPrecio(25200);
        r.setPp(7);
        r.setUnidad("Por unidad");
        return r;
    }

    public static ResponseRepuestoDto repuestoDto(){
        ResponseRepuestoDto r = new ResponseRepuestoDto();
        r.setId(1L);
        r.setNombre("Amortiguador trasero");
        r.setStock(8);
        r.setPrecio(27800);
        r.setPp(6);
        r.setUnidad("Por unidad");
        return r;
    }

    public static ResponseRepuestoDto repuestoDto2(){
        ResponseRepuestoDto r = new ResponseRepuestoDto();
        r.setId(2L);
        r.setNombre("Amortiguador delantero");
        r.setStock(10);
        r.setPrecio(25200);
        r.setPp(7);
        r.setUnidad("Por unidad");
        return r;
    }

    public static List<Repuesto> lista(){
        return List.of(repuesto(), repuesto2());
    }

    public static Set<ResponseRepuestoDto> listaDto(){
        return Set.of(repuestoDto(), repuestoDto2());
    }

    public static RepuestoRequestDto repuestoReqDto(){
        RepuestoRequestDto r = new RepuestoRequestDto();
        r.setNombre("Amortiguador trasero");
        r.setStock(8);
        r.setPrecio(27800);
        r.setPp(6);
        r.setUnidad("Por unidad");
        return r;
    }

    public static RepuestoRequestDto repuestoReqDto2(){
        RepuestoRequestDto r = new RepuestoRequestDto();
        r.setNombre("Amortiguador delantero");
        r.setStock(10);
        r.setPrecio(25200);
        r.setPp(7);
        r.setUnidad("Por unidad");
        return r;
    }
}
