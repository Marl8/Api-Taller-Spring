package com.taller.services.impl;

import com.taller.dto.request.ClienteRequestDto;
import com.taller.dto.request.ClienteUpdateDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseGetClientDto;
import com.taller.dto.response.ResponseGetClientesDto;
import com.taller.entity.Cliente;
import com.taller.errors.GenericException;
import com.taller.repository.ClienteRepository;
import com.taller.services.IClienteService;
import com.taller.utils.ClienteMapper;
import org.springframework.http.HttpStatus;
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
                () ->  new GenericException("Not found cliente", HttpStatus.NOT_FOUND)
        );
        return ClienteMapper.findCliente(cliente);
    }

    @Override
    public ResponseDto saveCliente(ClienteRequestDto clienteDto) {
        Optional<Cliente> existe = repository.findClienteByDni(clienteDto.getDni());
        if(existe.isPresent()) {
            throw new GenericException("El cliente ya existe", HttpStatus.BAD_REQUEST);
        }else {
            Cliente cliente = ClienteMapper.clienteRequestDto(clienteDto);
            repository.save(cliente);
        }
        return new ResponseDto("El cliente se ha guardado con éxito");
    }

    @Override
    public ResponseDto updateCliente(Long id, ClienteUpdateDto clienteDto) {
        Cliente existe = repository.findById(id).orElseThrow(
                () -> new GenericException("Cliente not found", HttpStatus.NOT_FOUND)
        );
        Cliente modificado = ClienteMapper.clienteUpdate(clienteDto, existe.getId());
        repository.save(modificado);
        return new ResponseDto("El cliente ha sido modificado con éxito");
    }

    @Override
    public ResponseDto deleteCliente(Long id) {
        Cliente existe = repository.findById(id).orElseThrow(
                ()-> new GenericException("Not found cliente", HttpStatus.NOT_FOUND)
        );
        repository.deleteById(existe.getId());
        return new ResponseDto("El cliente ha sido eliminado con éxito");
    }
}
