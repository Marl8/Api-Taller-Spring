package com.taller.utils;

import com.taller.dto.request.MecanicoRequestDto;
import com.taller.dto.response.ResponseMecanicoDto;
import com.taller.entity.Mecanico;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Set;

public class MecanicoObjectUtils {

    public static Mecanico mecanico(){
        Mecanico mecanico = new Mecanico();
        mecanico.setId(1L);
        mecanico.setNombre("Ramiro");
        mecanico.setApellido("Antunez");
        mecanico.setDni("34206573");
        mecanico.setTel("114589302");
        mecanico.setRepara(true);
        return mecanico;
    }

    public static Mecanico mecanico2(){
        Mecanico mecanico = new Mecanico();
        mecanico.setId(1L);
        mecanico.setNombre("Fabian");
        mecanico.setApellido("Sucre");
        mecanico.setDni("30158707");
        mecanico.setTel("116284125");
        mecanico.setRepara(false);
        return mecanico;
    }

    public static List<Mecanico> lista() {
        return List.of(mecanico(), mecanico2());
    }

    public static ResponseMecanicoDto mecanicoDto1(){
        ResponseMecanicoDto mecanico = new ResponseMecanicoDto();
        mecanico.setId(1L);
        mecanico.setNombre("Ramiro");
        mecanico.setApellido("Antunez");
        mecanico.setDni("34206573");
        mecanico.setTel("114589302");
        mecanico.setRepara(true);
        return mecanico;
    }

    public static ResponseMecanicoDto mecanicoDto2(){
        ResponseMecanicoDto mecanico = new ResponseMecanicoDto();
        mecanico.setId(1L);
        mecanico.setNombre("Fabian");
        mecanico.setApellido("Sucre");
        mecanico.setDni("30158707");
        mecanico.setTel("116284125");
        mecanico.setRepara(false);
        return mecanico;
    }

    public static Set<ResponseMecanicoDto> listaDtos(){
        return Set.of(mecanicoDto1(), mecanicoDto2());
    }

    public static MecanicoRequestDto mecanicoReqDto(){
        MecanicoRequestDto mecanico = new MecanicoRequestDto();
        mecanico.setNombre("Ramiro");
        mecanico.setApellido("Antunez");
        mecanico.setDni("34206573");
        mecanico.setTel("114589302");
        mecanico.setRepara(true);
        return mecanico;
    }
}
