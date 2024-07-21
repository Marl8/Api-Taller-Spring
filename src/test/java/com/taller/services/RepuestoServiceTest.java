package com.taller.services;

import com.taller.dto.request.RepuestoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseRepuestoDto;
import com.taller.entity.Repuesto;
import com.taller.repository.RepuestoRepository;
import com.taller.services.impl.RepuestoServiceImpl;
import com.taller.utils.RepuestoObjectUtils;
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
public class RepuestoServiceTest {

    @Mock
    RepuestoRepository repository;

    @InjectMocks
    RepuestoServiceImpl service;

    @Test
    @DisplayName("Test OK para find all repuestos")
    void findAllRepuestosTestOK(){
        List<Repuesto> lista = RepuestoObjectUtils.lista();
        Set<ResponseRepuestoDto> expected = RepuestoObjectUtils.listaDto();

        when(repository.findAll()).thenReturn(lista);
        Set<ResponseRepuestoDto> actual = service.findAllRespuestos();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para find repuesto by id")
    void findRepuestoByIdTestOK(){
        Long id = 1L;
        Repuesto rep = RepuestoObjectUtils.repuesto();
        ResponseRepuestoDto expected = RepuestoObjectUtils.repuestoDto();

        when(repository.findById(any())).thenReturn(Optional.of(rep));
        ResponseRepuestoDto actual = service.findById(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save repuesto")
    void saveRepuestoTestOK(){
        Repuesto repuesto = RepuestoObjectUtils.repuesto();
        RepuestoRequestDto argumentSut = RepuestoObjectUtils.repuestoReqDto();
        ResponseDto expected = new ResponseDto("Repuesto guardado con éxito");

        when(repository.findRepuestoByNombre(any())).thenReturn(Optional.empty());
        when(repository.save(any())).thenReturn(repuesto);
        ResponseDto actual = service.save(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para update repuesto")
    void updateRepuestoTestOK(){
        Long id = 1L;
        Repuesto rep = RepuestoObjectUtils.repuesto();
        Repuesto modificado = RepuestoObjectUtils.repuesto2();
        RepuestoRequestDto argumentSut = RepuestoObjectUtils.repuestoReqDto2();
        ResponseDto expected = new ResponseDto("Repuesto modificado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(rep));
        when(repository.save(any())).thenReturn(modificado);
        ResponseDto actual = service.update(argumentSut, id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para delete repuesto")
    void deleteRepuestoTestOK(){
        Long id = 1L;
        Repuesto rep = RepuestoObjectUtils.repuesto();
        ResponseDto expected = new ResponseDto("Repuesto eliminado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(rep));
        ResponseDto actual = service.delete(id);

        assertEquals(expected, actual);
    }
}
