package com.taller.services;

import com.taller.dto.request.MecRepRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseMecRepDto;
import java.util.Set;

public interface IMecRepService {

    Set<ResponseMecRepDto> findAll();

    ResponseMecRepDto findById(Long id);

    ResponseDto saveMecRep(MecRepRequestDto mecDto);

    ResponseDto update(MecRepRequestDto mecRepDto, Long id);

    ResponseDto delete(Long id);
}
