package com.taller.services.impl;

import com.taller.dto.response.RepuestoResponseDto;
import com.taller.entity.Repuesto;
import com.taller.repository.RepuestoRepository;
import com.taller.services.IRepuestoService;
import com.taller.utils.RepuestoMapper;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RepuestoServiceImpl implements IRepuestoService {

    RepuestoRepository repository;

    public RepuestoServiceImpl(RepuestoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<RepuestoResponseDto> findAllRespuestos() {
        List<Repuesto> repuestos = repository.findAll();
        List<RepuestoResponseDto> lista = RepuestoMapper.listaRepuestos(repuestos);
        return new HashSet<>(lista);
    }

    @Override
    public RepuestoResponseDto findById(Long id) {
        Repuesto rep = repository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Repuesto not found")
        );
        return RepuestoMapper.repuestoDto(rep);
    }
}
