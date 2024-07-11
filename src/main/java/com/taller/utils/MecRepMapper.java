package com.taller.utils;

import com.taller.dto.request.MecRepRequestDto;
import com.taller.dto.response.ResponseMecRepDto;
import com.taller.entity.MecRep;

import java.util.List;

public class MecRepMapper {

    public static List<ResponseMecRepDto> listaMecRepDto(List<MecRep> lista){
        return lista.stream().map(m -> new ResponseMecRepDto(m.getId(), m.getHoraEntrada(), m.getHoraSalida(),
                m.getMecanico().getId())).toList();
    }

    public static ResponseMecRepDto mecRepDto(MecRep mec){
        return new ResponseMecRepDto(mec.getId(), mec.getHoraEntrada(), mec.getHoraSalida(),mec.getMecanico().getId());
    }

    public static MecRep mecRep(MecRepRequestDto mec){
        MecRep mecrep = new MecRep();
         mecrep.setHoraEntrada(mec.getHoraEntrada());
         mecrep.setHoraSalida(mec.getHoraSalida());
         return mecrep;
    }
}
