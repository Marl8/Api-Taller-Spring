package com.taller.services;

import com.taller.dto.response.ResponseMecDiagDto;
import com.taller.entity.MecDiag;
import com.taller.repository.MecDiagRepository;
import com.taller.services.impl.MecDiagServiceImpl;
import com.taller.utils.MecDiagObjectUtils;
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
}
