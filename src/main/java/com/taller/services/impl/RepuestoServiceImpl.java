package com.taller.services.impl;

import com.taller.dto.request.RepuestoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseRepuestoDto;
import com.taller.entity.Repuesto;
import com.taller.errors.GenericException;
import com.taller.repository.RepuestoRepository;
import com.taller.services.IRepuestoService;
import com.taller.utils.RepuestoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RepuestoServiceImpl implements IRepuestoService {

    RepuestoRepository repository;

    public RepuestoServiceImpl(RepuestoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<ResponseRepuestoDto> findAllRespuestos() {
        List<Repuesto> repuestos = repository.findAll();
        List<ResponseRepuestoDto> lista = RepuestoMapper.listaRepuestos(repuestos);
        return new HashSet<>(lista);
    }

    @Override
    public ResponseRepuestoDto findById(Long id) {
        Repuesto rep = repository.findById(id).orElseThrow(
                ()-> new GenericException("Repuesto not found", HttpStatus.NOT_FOUND)
        );
        return RepuestoMapper.repuestoDto(rep);
    }

    @Override
    public ResponseDto save(RepuestoRequestDto rDto) {
        Optional<Repuesto> rep = repository.findRepuestoByNombre(rDto.getNombre());
        if(rep.isPresent()) {
            throw new GenericException("El repuesto ya existe", HttpStatus.BAD_REQUEST);
        }
        Repuesto r = RepuestoMapper.repuesto(rDto);
        repository.save(r);
        return new ResponseDto("Repuesto guardado con éxito");
    }

    @Override
    public ResponseDto update(RepuestoRequestDto r, Long id) {
        Repuesto rep = repository.findById(id).orElseThrow(
                ()-> new GenericException("Repuesto not found", HttpStatus.NOT_FOUND)
        );
        Repuesto modificado = new Repuesto();
        modificado.setId(rep.getId());
        modificado.setNombre(r.getNombre());
        modificado.setStock(r.getStock());
        modificado.setPp(r.getPp());
        modificado.setPrecio(r.getPrecio());
        modificado.setUnidad(r.getUnidad());
        repository.save(modificado);
        return new ResponseDto("Repuesto modificado con éxito");
    }

    @Override
    public ResponseDto delete(Long id) {
        Repuesto rep = repository.findById(id).orElseThrow(
                ()-> new GenericException("Repuesto not found", HttpStatus.NOT_FOUND)
        );
        repository.deleteById(rep.getId());
        return new ResponseDto("Repuesto eliminado con éxito");
    }
}
