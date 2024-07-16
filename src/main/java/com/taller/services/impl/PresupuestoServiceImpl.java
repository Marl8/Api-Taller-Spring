package com.taller.services.impl;

import com.taller.dto.request.PresupuestoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponsePresupuestoDto;
import com.taller.entity.Ficha;
import com.taller.entity.PresuRep;
import com.taller.entity.Presupuesto;
import com.taller.entity.Repuesto;
import com.taller.errors.GenericException;
import com.taller.repository.FichaRepository;
import com.taller.repository.PresuRepRepository;
import com.taller.repository.PresupuestoRepository;
import com.taller.repository.RepuestoRepository;
import com.taller.services.IPresupuestoService;
import com.taller.utils.PresupuestoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class PresupuestoServiceImpl implements IPresupuestoService {

    PresupuestoRepository repository;
    FichaRepository fichaRepository;
    RepuestoRepository repuestoRepository;
    PresuRepRepository pRepository;

    public PresupuestoServiceImpl(PresupuestoRepository repository, FichaRepository fichaRepository,
                                  PresuRepRepository pRepository, RepuestoRepository repuestoRepository) {
        this.repository = repository;
        this.fichaRepository = fichaRepository;
        this.pRepository = pRepository;
        this.repuestoRepository = repuestoRepository;
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
                ()-> new GenericException("Presupuesto not found", HttpStatus.NOT_FOUND)
        );
        return PresupuestoMapper.responseDto(presup);
    }

    @Override
    public ResponseDto save(PresupuestoRequestDto pDto) {
        Presupuesto presup = PresupuestoMapper.presupuesto(pDto);
        Ficha ficha = fichaRepository.findById(pDto.getFichaId()).orElseThrow(
                () -> new GenericException("Ficha not found", HttpStatus.NOT_FOUND)
        );
        presup.setFicha(ficha);
        Presupuesto guardado = repository.save(presup);
        if (pDto.getPresuRep() != null) {
            cargarRepuestos(guardado, pDto.getPresuRep());
            repository.save(presup);
        }
        return new ResponseDto("Presupuesto guardado con éxito");
    }

    public void cargarRepuestos(Presupuesto presup, Map<Long, Integer> mapa){
        Set<PresuRep> repuestos = new HashSet<>();
        for (Map.Entry<Long, Integer> m : mapa.entrySet()) {
            Repuesto rep = repuestoRepository.findById(m.getKey()).orElseThrow(
                    () -> new GenericException("Repuesto not found", HttpStatus.NOT_FOUND)
            );
            PresuRep presuRep = presup.getRepuestos().stream()
                    .filter(r -> r.getCodrep().equals(rep.getId()))
                    .findFirst()
                    .orElse(new PresuRep());

            presuRep.setNPresup(presup.getId());
            presuRep.setCodrep(rep.getId());
            presuRep.setCantidad(m.getValue());
            repuestos.add(presuRep);
            presup.getRepuestos().addAll(repuestos);
        }
    }

    @Override
    @Transactional
    public ResponseDto update(PresupuestoRequestDto p, Long id) {
        Presupuesto presup = repository.findById(id).orElseThrow(
                () -> new GenericException("Presupuesto not found", HttpStatus.NOT_FOUND)
        );
        Ficha ficha = fichaRepository.findById(p.getFichaId()).orElseThrow(
                () -> new GenericException("Ficha not found", HttpStatus.NOT_FOUND)
        );
        presup.setFecha(p.getFecha());
        presup.setDiagFinal(p.getDiagFinal());
        presup.setMonto(p.getMonto());
        presup.setAceptado(p.isAceptado());
        presup.setFicha(ficha);
        modificarRepuestos(presup, p.getPresuRep());
        repository.save(presup);
        return new ResponseDto("Presupuesto modificado con éxito");
    }

    @Transactional
    public void modificarRepuestos(Presupuesto presup, Map<Long, Integer> mapa) {
        Set<PresuRep> repuestos = new HashSet<>();
        for (Map.Entry<Long, Integer> m : mapa.entrySet()) {
            Repuesto rep = repuestoRepository.findById(m.getKey()).orElseThrow(
                    () -> new GenericException("Repuesto not found", HttpStatus.NOT_FOUND)
            );
            PresuRep presuRep = presup.getRepuestos().stream()
                    .filter(r -> r.getCodrep().equals(rep.getId()))
                    .findFirst()
                    .orElse(new PresuRep());

            presuRep.setNPresup(presup.getId());
            presuRep.setCodrep(rep.getId());
            presuRep.setCantidad(m.getValue());
            repuestos.add(presuRep);
        }
        // Eliminar los repuestos que ya no están en el mapa
        presup.getRepuestos().removeIf(r -> !repuestos.contains(r));

        // Actualizar la lista de repuestos
        presup.getRepuestos().clear();
        presup.getRepuestos().addAll(repuestos);
    }

    @Override
    public ResponseDto delete(Long id) {
        Presupuesto presup = repository.findById(id).orElseThrow(
                () -> new GenericException("Presupuesto not found", HttpStatus.NOT_FOUND)
        );
        repository.deleteById(presup.getId());
        return new ResponseDto("Presupuesto eliminado con éxito");
    }
}
