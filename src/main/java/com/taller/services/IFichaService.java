package com.taller.services;

import com.taller.dto.request.FichaRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseGetFichaDto;

public interface IFichaService {

    ResponseGetFichaDto getFichaById(Long id);

    ResponseDto saveFicha(FichaRequestDto fichaDto);

    ResponseDto deleteFicha(Long id);
}
