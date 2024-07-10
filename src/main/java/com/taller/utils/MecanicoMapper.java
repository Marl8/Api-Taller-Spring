package com.taller.utils;

import com.taller.dto.request.MecanicoRequestDto;
import com.taller.dto.response.ResponseMecanicoDto;
import com.taller.entity.Mecanico;

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
}
