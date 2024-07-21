package com.taller.services;

import com.taller.dto.request.PresupuestoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponsePresupuestoDto;
import com.taller.entity.Ficha;
import com.taller.entity.Presupuesto;
import com.taller.entity.Repuesto;
import com.taller.repository.FichaRepository;
import com.taller.repository.PresupuestoRepository;
import com.taller.repository.RepuestoRepository;
import com.taller.services.impl.PresupuestoServiceImpl;
import com.taller.utils.FichaObjectsUtils;
import com.taller.utils.PresupuestoObjectUtils;
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
public class PresupuestoServiceTest {

    @Mock
    PresupuestoRepository repository;

    @Mock
    FichaRepository fichaRepository;

    @Mock
    RepuestoRepository repuestoRepository;

    @InjectMocks
    PresupuestoServiceImpl service;

    @Test
    @DisplayName("Test OK para find all presupuestos")
    void findAllPresupuestosTestOK(){
        List<Presupuesto> lista = PresupuestoObjectUtils.lista();
        Set<ResponsePresupuestoDto> expected = PresupuestoObjectUtils.listaDto();

        when(repository.findAll()).thenReturn(lista);
        Set<ResponsePresupuestoDto> actual = service.findAll();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para find presupuesto by id")
    void findPresupuestoByIdTestOK(){
        Long id = 1L;
        Presupuesto presup = PresupuestoObjectUtils.presupuesto();
        ResponsePresupuestoDto expected = PresupuestoObjectUtils.presupuestoDto1();

        when(repository.findById(any())).thenReturn(Optional.of(presup));
        ResponsePresupuestoDto actual = service.findById(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save presupuesto")
    void savePresupuestoTestOK(){
        Presupuesto presup = PresupuestoObjectUtils.presupuesto();
        PresupuestoRequestDto argumentSut = PresupuestoObjectUtils.presupuestoReqDto();
        Ficha ficha = FichaObjectsUtils.ficha();
        Repuesto repuesto = RepuestoObjectUtils.repuesto();
        ResponseDto expected = new ResponseDto("Presupuesto guardado con éxito");

        when(fichaRepository.findById(any())).thenReturn(Optional.of(ficha));
        when(repuestoRepository.findById(any())).thenReturn(Optional.of(repuesto));
        when(repository.save(any())).thenReturn(presup);
        ResponseDto actual = service.save(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save presupuesto")
    void updatePresupuestoTestOK(){
        Long id = 1L;
        Presupuesto presup = PresupuestoObjectUtils.presupuesto();
        Presupuesto modificado = PresupuestoObjectUtils.presupuesto2();
        PresupuestoRequestDto argumentSut = PresupuestoObjectUtils.presupuestoReqDto2();
        Ficha ficha = FichaObjectsUtils.ficha();
        Repuesto repuesto = RepuestoObjectUtils.repuesto();
        ResponseDto expected = new ResponseDto("Presupuesto modificado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(presup));
        when(fichaRepository.findById(any())).thenReturn(Optional.of(ficha));
        when(repuestoRepository.findById(any())).thenReturn(Optional.of(repuesto));
        when(repository.save(any())).thenReturn(modificado);
        ResponseDto actual = service.update(argumentSut, id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para delete presupuesto")
    void deletePresupuestoTestOK(){
        Long id = 1L;
        Presupuesto presup = PresupuestoObjectUtils.presupuesto();
        ResponseDto expected = new ResponseDto("Presupuesto eliminado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(presup));
        ResponseDto actual = service.delete(id);

        assertEquals(expected, actual);
    }

}
