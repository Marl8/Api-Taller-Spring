package com.taller.services;

import com.taller.dto.response.ResponseGetClientDto;
import com.taller.dto.response.ResponseGetClientesDto;

import java.util.List;

public interface IClienteService {

    List<ResponseGetClientesDto> getClientes();

    ResponseGetClientDto getClient(Long id);
}
