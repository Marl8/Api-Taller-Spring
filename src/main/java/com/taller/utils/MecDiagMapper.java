package com.taller.utils;

import com.taller.dto.request.MecDiagRequestDto;
import com.taller.dto.response.ResponseMecDiagDto;
import com.taller.entity.MecDiag;

import java.util.List;

public class MecDiagMapper {

    public static List<ResponseMecDiagDto> listaMecDiag(List<MecDiag> mecDiags) {
        return mecDiags.stream().map(m -> new ResponseMecDiagDto(m.getId(),m.getTematica(),m.getMecanico().getId())).toList();
    }

    public static ResponseMecDiagDto getMecanico(MecDiag diag) {
        return new ResponseMecDiagDto(diag.getId(),diag.getTematica(),diag.getMecanico().getId());
    }

    public static MecDiag getMecDiag(MecDiagRequestDto diag) {
        MecDiag mec = new MecDiag();
        mec.setTematica(diag.getTematica());
        return mec;
    }
}
