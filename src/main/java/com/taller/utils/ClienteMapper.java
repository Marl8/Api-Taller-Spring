package com.taller.utils;

import com.taller.dto.ResponseGetClientesDto;
import com.taller.entity.Cliente;
import java.util.List;

public class ClienteMapper {

    public static List<ResponseGetClientesDto> findAllClientes(List<Cliente> clientes){
        return clientes.stream().map(c-> new ResponseGetClientesDto(c.getId(),c.getNombre(),c.getApellido(),
        c.getDireccion(),c.getDni(),c.getTel())).toList();
    }
}
