package com.taller.services;

import com.taller.dto.request.MecRepRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseMecRepDto;
import com.taller.entity.MecRep;
import com.taller.entity.Mecanico;
import com.taller.repository.MecRepRepository;
import com.taller.repository.MecanicoRepository;
import com.taller.services.impl.MecRepServiceImpl;
import com.taller.utils.MecRepObjectUtils;
import com.taller.utils.MecanicoObjectUtils;
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
public class MecRepServiceTest {

    @Mock
    MecRepRepository repository;

    @Mock
    MecanicoRepository  mecanicoRepository;

    @InjectMocks
    MecRepServiceImpl service;

    @Test
    @DisplayName("Test OK para find all mecánicos que reparan")
    void findAllMecRepTestOK(){
        List<MecRep> lista = MecRepObjectUtils.lista();
        Set<ResponseMecRepDto> expected = MecRepObjectUtils.listaDto();

        when(repository.findAll()).thenReturn(lista);
        Set<ResponseMecRepDto> actual = service.findAll();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para find by id mecánico que repara")
    void findByIdMecRepTestOK(){
        Long id = 1L;
        MecRep mecRep = MecRepObjectUtils.mecRep1();
        ResponseMecRepDto expected = MecRepObjectUtils.mecRepDto1();

        when(repository.findById(any())).thenReturn(Optional.of(mecRep));
        ResponseMecRepDto actual = service.findById(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save MecRep")
    void saveMecRepTestOK(){
        MecRep mecRep = MecRepObjectUtils.mecRep1();
        MecRepRequestDto argumentSut = MecRepObjectUtils.mecRepReqDto();
        Mecanico mecanico = MecanicoObjectUtils.mecanico();
        ResponseDto expected = new ResponseDto("Guardado con éxito");

        when(mecanicoRepository.findById(any())).thenReturn(Optional.of(mecanico));
        when(repository.save(any())).thenReturn(mecRep);
        ResponseDto actual = service.saveMecRep(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para update MecRep")
    void updateMecRepTestOK(){
        Long id = 1L;
        MecRep mecRep = MecRepObjectUtils.mecRep1();
        MecRep modificado = MecRepObjectUtils.mecRep2();
        MecRepRequestDto argumentSut = MecRepObjectUtils.mecRepReqDto();
        Mecanico mecanico = MecanicoObjectUtils.mecanico();
        ResponseDto expected = new ResponseDto("Modificado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(mecRep));
        when(mecanicoRepository.findById(any())).thenReturn(Optional.of(mecanico));
        when(repository.save(any())).thenReturn(modificado);
        ResponseDto actual = service.update(argumentSut, id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para delete MecRep")
    void deleteMecRepTestOk(){
        Long id = 1L;
        MecRep mecRep = MecRepObjectUtils.mecRep1();
        ResponseDto expected = new ResponseDto("Eliminado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(mecRep));
        ResponseDto actual= service.delete(id);

        assertEquals(expected, actual);
    }
}
