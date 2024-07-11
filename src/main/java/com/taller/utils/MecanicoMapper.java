package com.taller.utils;

import com.taller.dto.request.MecanicoRequestDto;
import com.taller.dto.response.ResponseMecanicoDto;
import com.taller.entity.Mecanico;

import java.util.List;

public class MecanicoMapper {

    public static ResponseMecanicoDto mecanicoDto(Mecanico mecanico) {
        return new ResponseMecanicoDto(mecanico.getId(), mecanico.getNombre(), mecanico.getApellido(),
                mecanico.getDni(),mecanico.getTel(),mecanico.isRepara());
    }

    public static Mecanico getMecanico(MecanicoRequestDto mecanicoDto){
        Mecanico mecanico = new Mecanico();
        mecanico.setNombre(mecanicoDto.getNombre());
        mecanico.setApellido(mecanicoDto.getApellido());
        mecanico.setDni(mecanicoDto.getDni());
        mecanico.setTel(mecanicoDto.getTel());
        mecanico.setRepara(mecanico.isRepara());
        return mecanico;
    }

    public static List<ResponseMecanicoDto> listaMecanicos(List<Mecanico> mecanicos){
        return mecanicos.stream().map(m -> new ResponseMecanicoDto(m.getId(), m.getNombre(),m.getApellido(),
                m.getDni(),m.getTel(),m.isRepara())).toList();
    }
}
