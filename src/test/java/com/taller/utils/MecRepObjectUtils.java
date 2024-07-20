package com.taller.utils;

import com.taller.dto.request.MecRepRequestDto;
import com.taller.dto.response.ResponseMecRepDto;
import com.taller.entity.MecRep;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public class MecRepObjectUtils {

    public static MecRep mecRep1(){
        MecRep mecRep = new MecRep();
        mecRep.setId(1L);
        mecRep.setMecanico(MecanicoObjectUtils.mecanico());
        mecRep.setHoraEntrada(LocalTime.of(11,15,0));
        mecRep.setHoraSalida(LocalTime.of(18,39,46));
        return mecRep;
    }

    public static MecRep mecRep2(){
        MecRep mecRep = new MecRep();
        mecRep.setId(2L);
        mecRep.setMecanico(MecanicoObjectUtils.mecanico2());
        mecRep.setHoraEntrada(LocalTime.of(9,7,23));
        mecRep.setHoraSalida(LocalTime.of(17,32,12));
        return mecRep;
    }

    public static ResponseMecRepDto mecRepDto1(){
        ResponseMecRepDto mecRep = new ResponseMecRepDto();
        mecRep.setId(1L);
        mecRep.setIdMecanico(MecanicoObjectUtils.mecanico().getId());
        mecRep.setHoraEntrada(LocalTime.of(11,15,0));
        mecRep.setHoraSalida(LocalTime.of(18,39,46));
        return mecRep;
    }

    public static ResponseMecRepDto mecRepDto2(){
        ResponseMecRepDto mecRep = new ResponseMecRepDto();
        mecRep.setId(2L);
        mecRep.setIdMecanico(MecanicoObjectUtils.mecanico2().getId());
        mecRep.setHoraEntrada(LocalTime.of(9,7,23));
        mecRep.setHoraSalida(LocalTime.of(17,32,12));
        return mecRep;
    }

    public static List<MecRep> lista(){
        return List.of(mecRep1(),mecRep2());
    }

    public static Set<ResponseMecRepDto> listaDto(){
        return Set.of(mecRepDto1(),mecRepDto2());
    }

    public static MecRepRequestDto mecRepReqDto(){
        MecRepRequestDto mecRep = new MecRepRequestDto();
        mecRep.setIdMecanico(MecanicoObjectUtils.mecanico().getId());
        mecRep.setHoraEntrada("11:15:00");
        mecRep.setHoraSalida("18:39:46");
        return mecRep;
    }
}
