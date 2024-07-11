package com.taller.services;

import com.taller.dto.request.MecDiagRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseMecDiagDto;

import java.util.Set;

public interface IMecDiagService {

    Set<ResponseMecDiagDto> findAllMecDiag();

    ResponseMecDiagDto findById(Long id);

    ResponseDto save(MecDiagRequestDto mecdiag);

    ResponseDto update(MecDiagRequestDto mecdiag, Long id);

    ResponseDto delete(Long id);
}

