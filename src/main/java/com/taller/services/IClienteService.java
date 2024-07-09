package com.taller.services;

import com.taller.dto.request.ClienteRequestDto;
import com.taller.dto.request.ClienteUpdateDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseGetClientDto;
import com.taller.dto.response.ResponseGetClientesDto;

import java.util.List;

public interface IClienteService {

    List<ResponseGetClientesDto> getClientes();

    ResponseGetClientDto getClient(Long id);

    ResponseDto saveCliente(ClienteRequestDto clienteDto);

    ResponseDto updateCliente(Long id, ClienteUpdateDto clienteDto);

    ResponseDto deleteCliente(Long id);
}
