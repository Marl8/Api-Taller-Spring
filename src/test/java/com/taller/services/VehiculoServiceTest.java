package com.taller.services;

import com.taller.dto.request.VehiculoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseVehiculoDto;
import com.taller.entity.Cliente;
import com.taller.entity.Vehiculo;
import com.taller.repository.ClienteRepository;
import com.taller.repository.VehiculoRepository;
import com.taller.services.impl.VehiculoServiceImpl;
import com.taller.utils.ClienteObjectUtils;
import com.taller.utils.VehiculoObjectUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VehiculoServiceTest {

    @Mock
    VehiculoRepository repository;

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    VehiculoServiceImpl service;

    @Test
    @DisplayName("Test OK para find all Vehículos")
    void findAllVehiculosTestOK(){
        List<Vehiculo> lista = VehiculoObjectUtils.lista();
        Set<ResponseVehiculoDto> expected = VehiculoObjectUtils.listaDto();

        when(repository.findAll()).thenReturn(lista);
        Set<ResponseVehiculoDto> actual = service.findAllVehiculos();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para find Vehículo by id")
    void findVehiculoByIdTestOK(){
        Long id = 1L;
        Vehiculo vehiculo = VehiculoObjectUtils.vehiculo();
        ResponseVehiculoDto expected = VehiculoObjectUtils.vehiculoDto();

        when(repository.findById(any())).thenReturn(Optional.of(vehiculo));
        ResponseVehiculoDto actual = service.findById(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save Vehículo")
    void saveVehiculoTestOK(){
        Vehiculo vehiculo = VehiculoObjectUtils.vehiculo();
        VehiculoRequestDto argumentSut = VehiculoObjectUtils.vehiculoReqDto();
        Cliente cliente = ClienteObjectUtils.cliente1();
        ResponseDto expected = new ResponseDto("Vehiculo guardado con éxito");

        when(repository.findVehiculoByMatricula(any())).thenReturn(Optional.empty());
        when(clienteRepository.findById(any())).thenReturn(Optional.of(cliente));
        when(repository.save(any())).thenReturn(vehiculo);
        ResponseDto actual = service.save(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para update Vehículo")
    void updateVehiculoTestOK(){
        Long id = 1L;
        Vehiculo vehiculo = VehiculoObjectUtils.vehiculo();
        Vehiculo modificado = VehiculoObjectUtils.vehiculo2();
        VehiculoRequestDto argumentSut = VehiculoObjectUtils.vehiculoReqDto();
        Cliente cliente = ClienteObjectUtils.cliente1();
        ResponseDto expected = new ResponseDto("Vehículo modificado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(vehiculo));
        when(clienteRepository.findById(any())).thenReturn(Optional.of(cliente));
        when(repository.save(any())).thenReturn(modificado);
        ResponseDto actual = service.updateVehiculos(id, argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para delete Vehículo")
    void deleteVehiculoTestOK(){
        Long id = 1L;
        Vehiculo vehiculo = VehiculoObjectUtils.vehiculo();
        ResponseDto expected = new ResponseDto("Vehículo eliminado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(vehiculo));
        ResponseDto actual = service.delete(id);

        assertEquals(expected, actual);
    }
}
