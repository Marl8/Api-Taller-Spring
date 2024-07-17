package com.taller.utils;

import com.taller.dto.request.ClienteRequestDto;
import com.taller.dto.request.ClienteUpdateDto;
import com.taller.dto.response.ResponseGetClientDto;
import com.taller.dto.response.ResponseGetClientesDto;
import com.taller.dto.response.ResponseVehiculoDto;
import com.taller.entity.Cliente;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteObjectUtils {

    public static List<Cliente> listaClientes() {
        return List.of(cliente1(),cliente2());
    }

    public static List<ResponseGetClientesDto> listaClientesDto() {
            return List.of(clienteDto1(),clienteDto2());
    }

    public static Cliente cliente1() {
        Cliente c = new Cliente();
        c.setId(25L);
        c.setNombre("Arturo");
        c.setApellido("Sandes");
        c.setDni("31205658");
        c.setDireccion("Balcarce 3254");
        c.setTel("113365898");
        return c;
    }

    public static Cliente cliente2() {
        Cliente c = new Cliente();
        c.setId(25L);
        c.setNombre("Carlos");
        c.setApellido("Fabre");
        c.setDni("271205039");
        c.setDireccion("San Luis 1580");
        c.setTel("113214566");
        return c;
    }

    public static ResponseGetClientesDto clienteDto1() {
        ResponseGetClientesDto c = new ResponseGetClientesDto();
        c.setId(25L);
        c.setNombre("Arturo");
        c.setApellido("Sandes");
        c.setDni("31205658");
        c.setDireccion("Balcarce 3254");
        c.setTel("113365898");
        return c;
    }

    public static ResponseGetClientesDto clienteDto2() {
        ResponseGetClientesDto c = new ResponseGetClientesDto();
        c.setId(25L);
        c.setNombre("Carlos");
        c.setApellido("Fabre");
        c.setDni("271205039");
        c.setDireccion("San Luis 1580");
        c.setTel("113214566");
        return c;
    }

    public static ResponseGetClientDto clienteDto() {
        ResponseGetClientDto c = new ResponseGetClientDto();
        Set<ResponseVehiculoDto> vehiculos = new HashSet<>();
        c.setId(25L);
        c.setNombre("Arturo");
        c.setApellido("Sandes");
        c.setDni("31205658");
        c.setTel("113365898");
        c.setDireccion("Balcarce 3254");
        c.setVehiculos(vehiculos);
        return c;
    }

    public static ClienteRequestDto clienteReq() {
        ClienteRequestDto c = new ClienteRequestDto();
        c.setNombre("Arturo");
        c.setApellido("Sandes");
        c.setDni("31205658");
        c.setTel("113365898");
        c.setDireccion("Balcarce 3254");
        return c;
    }

    public static ClienteUpdateDto clienteUpdate() {
        ClienteUpdateDto c = new ClienteUpdateDto();
        List<Long> idVehiculos = new ArrayList<>();
        c.setNombre("Carlos");
        c.setApellido("Fabre");
        c.setDni("271205039");
        c.setDireccion("San Luis 1580");
        c.setTel("113214566");
        c.setVehiculosId(idVehiculos);
        return c;
    }
}
