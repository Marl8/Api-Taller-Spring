package com.taller.services.impl;

import com.taller.dto.ResponseGetClientesDto;
import com.taller.entity.Cliente;
import com.taller.repository.ClienteRepository;
import com.taller.services.IClienteService;
import com.taller.utils.ClienteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
