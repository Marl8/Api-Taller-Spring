package com.taller.services;

import com.taller.dto.request.FichaMdRequestDto;
import com.taller.dto.request.FichaRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseGetFichaDto;
import com.taller.entity.Ficha;
import com.taller.entity.FichaMd;
import com.taller.entity.MecDiag;
import com.taller.entity.Vehiculo;
import com.taller.repository.FichaMdRepository;
import com.taller.repository.FichaRepository;
import com.taller.repository.MecDiagRepository;
import com.taller.repository.VehiculoRepository;
import com.taller.services.impl.FichaServiceImpl;
import com.taller.utils.FichaObjectsUtils;
import com.taller.utils.MecDiagObjectUtils;
import com.taller.utils.VehiculoObjectUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FichaServiceTest {

    @Mock
    FichaRepository repository;

    @Mock
    VehiculoRepository vehiculoRepository;

    @Mock
    FichaMdRepository fichaMdRepository;

    @Mock
    MecDiagRepository mecDiagRepository;

    @InjectMocks
    FichaServiceImpl service;

    @Test
    @DisplayName("Test Ok para find by id")
    void findFichaByIdTestOK(){
        Long id = 1L;
        Ficha ficha = FichaObjectsUtils.ficha();
        ResponseGetFichaDto expected = FichaObjectsUtils.fichaDto();

        when(repository.findById(any())).thenReturn(Optional.of(ficha));
        ResponseGetFichaDto actual = service.getFichaById(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save Ficha")
    void saveFichaTestOk(){
        Ficha ficha = FichaObjectsUtils.ficha();
        FichaRequestDto argumentSut = FichaObjectsUtils.fichaRequestDto();
        Vehiculo vehiculo = VehiculoObjectUtils.vehiculo();
        ResponseDto expected = new ResponseDto("Ficha guardada con éxito");

        when(vehiculoRepository.findById(any())).thenReturn(Optional.of(vehiculo));
        when(repository.save(any())).thenReturn(ficha);
        ResponseDto actual = service.saveFicha(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para delete Ficha")
    void deleteFichaTestOK(){
        Long id = 1L;
        Ficha ficha = FichaObjectsUtils.ficha();
        ResponseDto expected = new ResponseDto("Ficha eliminada con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(ficha));
        ResponseDto actual = service.deleteFicha(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save Informe")
    void saveInformeTestOK(){
        Long idFicha = 1L;
        Long idMecDiag = 1L;
        Ficha ficha = FichaObjectsUtils.ficha();
        MecDiag mecDiag = MecDiagObjectUtils.mecDiag();
        FichaMd fichaMd = FichaObjectsUtils.fichaMd();
        FichaMdRequestDto argumentSut = FichaObjectsUtils.mdRequestDto();
        ResponseDto expected = new ResponseDto("Informe guardado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(ficha));
        when(mecDiagRepository.findById(any())).thenReturn(Optional.of(mecDiag));
        when(fichaMdRepository.save(any())).thenReturn(fichaMd);
        ResponseDto actual = service.informe(argumentSut, idFicha,idMecDiag);

        assertEquals(expected, actual);
    }
}
