package com.taller.services;

import com.taller.dto.request.MecDiagRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseMecDiagDto;
import com.taller.entity.MecDiag;
import com.taller.entity.Mecanico;
import com.taller.repository.MecDiagRepository;
import com.taller.repository.MecanicoRepository;
import com.taller.services.impl.MecDiagServiceImpl;
import com.taller.utils.MecDiagObjectUtils;
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
public class MecDiagServiceTest {

    @Mock
    MecDiagRepository repository;

    @Mock
    MecanicoRepository mecanicoRepository;

    @InjectMocks
    MecDiagServiceImpl service;

    @Test
    @DisplayName("Test OK para find all Mecánicos que Diagnostican")
    void findAllMecDiagTestOK(){
        List<MecDiag> list = MecDiagObjectUtils.listaMecdiag();
        Set<ResponseMecDiagDto> expected = MecDiagObjectUtils.listaDto();

        when(repository.findAll()).thenReturn(list);
        Set<ResponseMecDiagDto> actual = service.findAllMecDiag();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para find by id Mecánico que Diagnostican")
    void findByIdMecDiagTestOK(){
        Long id = 1L;
        MecDiag mecDiag = MecDiagObjectUtils.mecDiag();
        ResponseMecDiagDto expected = MecDiagObjectUtils.mecDiagDto();

        when(repository.findById(any())).thenReturn(Optional.of(mecDiag));
        ResponseMecDiagDto actual = service.findById(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save MecDiag")
    void saveMecDiagTestOK(){
        MecDiag mecDiag = MecDiagObjectUtils.mecDiag();
        Mecanico mecanico = MecanicoObjectUtils.mecanico();
        MecDiagRequestDto argumentSut = MecDiagObjectUtils.mecDiagReqDto();
        ResponseDto expected = new ResponseDto("Se ha guardado con éxito");

        when(mecanicoRepository.findById(any())).thenReturn(Optional.of(mecanico));
        when(repository.save(any())).thenReturn(mecDiag);
        ResponseDto actual = service.save(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para update MecDiag")
    void updateMecDiagTestOK(){
        Long id = 1L;
        MecDiag mecDiag = MecDiagObjectUtils.mecDiag();
        MecDiag modificado = MecDiagObjectUtils.mecDiag2();
        MecDiagRequestDto argumentSut = MecDiagObjectUtils.mecDiagReqDto();
        Mecanico mecanico = MecanicoObjectUtils.mecanico();
        ResponseDto expected = new ResponseDto("Modificación realizada con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(mecDiag));
        when(mecanicoRepository.findById(any())).thenReturn(Optional.of(mecanico));
        when(repository.save(any())).thenReturn(modificado);
        ResponseDto actual = service.update(argumentSut, id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para delete MecDiag")
    void deleteMecDiagTestOK(){
        Long id = 1L;
        MecDiag mecDiag = MecDiagObjectUtils.mecDiag();
        ResponseDto expected = new ResponseDto("Eliminado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(mecDiag));
        ResponseDto actual = service.delete(id);

        assertEquals(expected, actual);
    }
}
