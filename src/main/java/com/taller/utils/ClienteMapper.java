package com.taller.utils;

import com.taller.dto.request.ClienteRequestDto;
import com.taller.dto.request.ClienteUpdateDto;
import com.taller.dto.request.VehiculoRequestDto;
import com.taller.dto.response.ResponseGetClientDto;
import com.taller.dto.response.ResponseGetClientesDto;
import com.taller.entity.Cliente;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteMapper {

    public static List<ResponseGetClientesDto> findAllClientes(List<Cliente> clientes){
        return clientes.stream().map(c-> new ResponseGetClientesDto(c.getId(),c.getNombre(),c.getApellido(),
        c.getDireccion(),c.getDni(),c.getTel())).toList();
    }

    public static ResponseGetClientDto findCliente(Cliente cliente){
        Set<VehiculoRequestDto> result = cliente.getVehiculos().stream().map(v-> new VehiculoRequestDto(v.getId(),
                v.getModelo(), v.getMarca(), v.getMatricula(), v.getColor(), cliente.getId())).collect(Collectors.toSet());
        return new ResponseGetClientDto(cliente.getId(),cliente.getNombre(),cliente.getApellido(),
                cliente.getDni(),cliente.getTel(), cliente.getDireccion(), result);
    }

    public static Cliente clienteRequestDto(ClienteRequestDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setDni(clienteDto.getDni());
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setTel(clienteDto.getTel());
        return cliente;
    }

    public static Cliente clienteUpdate(ClienteUpdateDto clienteDto, Long id){
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setDni(clienteDto.getDni());
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setTel(clienteDto.getTel());
        return cliente;
    }

}
