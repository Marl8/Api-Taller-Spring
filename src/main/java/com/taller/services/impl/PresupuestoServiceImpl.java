package com.taller.services.impl;

import com.taller.dto.request.PresupuestoRequestDto;
import com.taller.dto.response.ResponsePresupuestoDto;
import com.taller.entity.Presupuesto;
import com.taller.repository.PresupuestoRepository;
import com.taller.services.IPresupuestoService;
import com.taller.utils.PresupuestoMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PresupuestoServiceImpl implements IPresupuestoService {

    PresupuestoRepository repository;

    public PresupuestoServiceImpl(PresupuestoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<ResponsePresupuestoDto> findAll() {
        List<Presupuesto> presupuestos = repository.findAll();
        List<ResponsePresupuestoDto> lista = PresupuestoMapper.findAll(presupuestos);
        return new HashSet<>(lista);
    }

    @Override
    public ResponsePresupuestoDto findById(Long id) {
        Presupuesto presup = repository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Presupuesto not found")
        );
        return PresupuestoMapper.findById(presup);
    }
}
