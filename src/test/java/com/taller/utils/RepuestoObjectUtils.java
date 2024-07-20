package com.taller.utils;

import com.taller.entity.Repuesto;

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
}
