package com.taller.services;

import com.taller.dto.request.ClienteRequestDto;
import com.taller.dto.request.ClienteUpdateDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseGetClientDto;
import com.taller.dto.response.ResponseGetClientesDto;
import com.taller.entity.Cliente;
import com.taller.repository.ClienteRepository;
import com.taller.services.impl.ClienteServiceImpl;
import com.taller.utils.ClienteObjectUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    ClienteRepository repository;

    @InjectMocks
    ClienteServiceImpl service;

    @Test
    @DisplayName("Test OK para find all clientes")
    void FindAllTestOK(){
        List<Cliente> clientes = ClienteObjectUtils.listaClientes();
        List<ResponseGetClientesDto> expected = ClienteObjectUtils.listaClientesDto();

        when(repository.findAll()).thenReturn(clientes);

        List<ResponseGetClientesDto> actual = service.getClientes();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para find by clientes")
    void findByIdVehiculosTestOK(){
        Long id = 1L;
        Cliente cliente = ClienteObjectUtils.cliente1();
        ResponseGetClientDto expected = ClienteObjectUtils.clienteDto();

        when(repository.findById(any())).thenReturn(Optional.of(cliente));
        ResponseGetClientDto actual = service.getClient(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save clientes")
    void saveVehiculosTestOK(){
        ClienteRequestDto argumentSut = ClienteObjectUtils.clienteReq();
        Cliente cliente = ClienteObjectUtils.cliente1();
        ResponseDto expected = new ResponseDto("El cliente se ha guardado con éxito");

        when(repository.findClienteByDni(any())).thenReturn(Optional.empty());
        when(repository.save(any())).thenReturn(cliente);
        ResponseDto actual = service.saveCliente(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para update clientes")
    void updateClienteTestOK(){
        Long id = 1L;
        Cliente cliente = ClienteObjectUtils.cliente1();
        ClienteUpdateDto argumentSut = ClienteObjectUtils.clienteUpdate();
        Cliente modificado = ClienteObjectUtils.cliente2();
        ResponseDto expected = new ResponseDto("El cliente ha sido modificado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(cliente));
        when(repository.save(any())).thenReturn(modificado);

        ResponseDto actual = service.updateCliente(id, argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para delete clientes")
    void deleClienteTestOK(){
        Long id = 1L;
        Cliente argumentSut = ClienteObjectUtils.cliente1();
        ResponseDto expected = new ResponseDto("El cliente ha sido eliminado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(argumentSut));
        ResponseDto actual = service.deleteCliente(id);

        assertEquals(expected, actual);
    }
}
