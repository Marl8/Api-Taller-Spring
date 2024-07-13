package com.taller.services.impl;

import com.taller.dto.request.PresupuestoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponsePresupuestoDto;
import com.taller.entity.Ficha;
import com.taller.entity.PresuRep;
import com.taller.entity.Presupuesto;
import com.taller.entity.Repuesto;
import com.taller.repository.FichaRepository;
import com.taller.repository.PresuRepRepository;
import com.taller.repository.PresupuestoRepository;
import com.taller.repository.RepuestoRepository;
import com.taller.services.IPresupuestoService;
import com.taller.utils.PresupuestoMapper;
import org.springframework.stereotype.Service;
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
                ()-> new IllegalStateException("Presupuesto not found")
        );
        return PresupuestoMapper.responseDto(presup);
    }

    @Override
    public ResponseDto save(PresupuestoRequestDto pDto) {
        Presupuesto presup = PresupuestoMapper.presupuesto(pDto);
        Ficha ficha = fichaRepository.findById(pDto.getFichaId()).orElseThrow(
                () -> new IllegalStateException("Ficha not found")
        );
        presup.setFicha(ficha);
        Presupuesto guardado = repository.save(presup);
        if (pDto.getPresuRep() != null) {
            cargarRepuestos(guardado, pDto.getPresuRep());
        }
        return new ResponseDto("Presupuesto guardado con éxito");
    }

    public void cargarRepuestos(Presupuesto presup, Map<Long, Integer> mapa){
        Set<PresuRep> repuestos = new HashSet<>();
        for(Map.Entry<Long, Integer> m: mapa.entrySet()) {
            Repuesto rep = repuestoRepository.findById(m.getKey()).orElseThrow(
                    () -> new IllegalStateException("Repuesto not found")
            );
            PresuRep p = new PresuRep();
            p.setNPresurep(presup.getId());
            p.setCodrep(rep.getId());
            p.setCantidad(m.getValue());
            System.out.println(p);
            pRepository.save(p);
            repuestos.add(p);
        }
        presup.setRepuestos(repuestos);
        repository.save(presup);
    }
}
