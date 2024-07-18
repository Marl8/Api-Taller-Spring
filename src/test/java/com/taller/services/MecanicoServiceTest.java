package com.taller.services;

import com.taller.dto.request.MecanicoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseMecanicoDto;
import com.taller.entity.Mecanico;
import com.taller.repository.MecanicoRepository;
import com.taller.services.impl.MecanicoServiceImpl;
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
public class MecanicoServiceTest {

    @Mock
    MecanicoRepository repository;

    @InjectMocks
    MecanicoServiceImpl service;

    @Test
    @DisplayName("Test OK para find all mecánicos")
    void findAllMecanicosTestOK(){
        List<Mecanico> lista = MecanicoObjectUtils.lista();
        Set<ResponseMecanicoDto> expected = MecanicoObjectUtils.listaDtos();

        when(repository.findAll()).thenReturn(lista);
        Set<ResponseMecanicoDto> actual = service.findAllMecanicos();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para find mecánico by id")
    void findMecanicoByIdTestOK(){
        Long id = 1L;
        Mecanico mecanico = MecanicoObjectUtils.mecanico();
        ResponseMecanicoDto expected = MecanicoObjectUtils.mecanicoDto1();

        when(repository.findById(any())).thenReturn(Optional.of(mecanico));
        ResponseMecanicoDto actual = service.findMecanicoById(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save mecánico")
    void saveMacanicoTestOK(){
        Mecanico mecanico = MecanicoObjectUtils.mecanico();
        MecanicoRequestDto argumentSut = MecanicoObjectUtils.mecanicoReqDto();
        ResponseDto expected = new ResponseDto("Mecánico guardado con éxito");

        when(repository.findMecanicoByDni(any())).thenReturn(Optional.empty());
        when(repository.save(any())).thenReturn(mecanico);
        ResponseDto actual = service.saveMecanico(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para update mecánico")
    void updateMecanicoTestOk(){
        Long id = 1L;
        Mecanico mecanico = MecanicoObjectUtils.mecanico();
        Mecanico modificado = MecanicoObjectUtils.mecanico2();
        MecanicoRequestDto argumentSut = MecanicoObjectUtils.mecanicoReqDto();
        ResponseDto expected = new ResponseDto("Mecánico modificado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(mecanico));
        when(repository.save(any())).thenReturn(modificado);
        ResponseDto actual = service.updateMecanico(id, argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para delete mecánico")
    void deleteMecanicoTestOk(){
        Long id = 1L;
        Mecanico mecanico = MecanicoObjectUtils.mecanico();
        ResponseDto expected = new ResponseDto("Mecánico eliminado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(mecanico));
        ResponseDto actual = service.deleteMecanico(id);

        assertEquals(expected, actual);
    }
}
