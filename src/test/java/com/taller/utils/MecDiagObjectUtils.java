package com.taller.utils;

import com.taller.dto.response.ResponseMecDiagDto;
import com.taller.entity.MecDiag;

import java.util.List;
import java.util.Set;

public class MecDiagObjectUtils {

    public static MecDiag mecDiag(){
        MecDiag mecDiag = new MecDiag();
        mecDiag.setId(1L);
        mecDiag.setTematica("Motor");
        mecDiag.setMecanico(MecanicoObjectUtils.mecanico());
        return mecDiag;
    }

    public static MecDiag mecDiag2(){
        MecDiag mecDiag = new MecDiag();
        mecDiag.setId(2L);
        mecDiag.setTematica("Fallos eléctricos");
        mecDiag.setMecanico(MecanicoObjectUtils.mecanico2());
        return mecDiag;
    }

    public static ResponseMecDiagDto mecDiagDto(){
        ResponseMecDiagDto mecDiag = new ResponseMecDiagDto();
        mecDiag.setId(1L);
        mecDiag.setTematica("Motor");
        mecDiag.setIdMecanico(MecanicoObjectUtils.mecanico().getId());
        return mecDiag;
    }

    public static ResponseMecDiagDto mecDiagDto2(){
        ResponseMecDiagDto mecDiag = new ResponseMecDiagDto();
        mecDiag.setId(2L);
        mecDiag.setTematica("Fallos eléctricos");
        mecDiag.setIdMecanico(MecanicoObjectUtils.mecanico2().getId());
        return mecDiag;
    }

    public static List<MecDiag> listaMecdiag(){
        return List.of(mecDiag(),mecDiag2());
    }

    public static Set<ResponseMecDiagDto> listaDto(){
        return Set.of(mecDiagDto(),mecDiagDto2());
    }
}
