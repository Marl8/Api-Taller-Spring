package com.taller.services.impl;

import com.taller.dto.request.ClienteRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseGetClientDto;
import com.taller.dto.response.ResponseGetClientesDto;
import com.taller.entity.Cliente;
import com.taller.repository.ClienteRepository;
import com.taller.services.IClienteService;
import com.taller.utils.ClienteMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteServiceImpl implements IClienteService {

    ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ResponseGetClientesDto> getClientes() {
        List<Cliente> listaClientes = repository.findAll();
            return ClienteMapper.findAllClientes(listaClientes);
    }

    @Override
    public ResponseGetClientDto getClient(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(
                () ->  new RuntimeException("Not found cliente")
        );
        System.out.println(cliente.getVehiculos());
        return ClienteMapper.findCliente(cliente);
    }

    @Override
    public ResponseDto saveCliente(ClienteRequestDto clienteDto) {
        Cliente guardado = new Cliente();
        Optional<Cliente> existe = repository.findClienteByDni(clienteDto.getDni());
        if(existe.isPresent()) {
            throw new IllegalStateException("El cliente ya existe");
        }else {
            Cliente cliente = ClienteMapper.clienteRequestDto(clienteDto);
            guardado = repository.save(cliente);
        }
        return new ResponseDto("El cliente se ha guardado con éxito");
    }
}
