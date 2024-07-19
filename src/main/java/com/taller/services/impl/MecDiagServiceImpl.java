package com.taller.services.impl;

import com.taller.dto.request.MecDiagRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseMecDiagDto;
import com.taller.entity.MecDiag;
import com.taller.entity.Mecanico;
import com.taller.errors.GenericException;
import com.taller.repository.MecDiagRepository;
import com.taller.repository.MecanicoRepository;
import com.taller.services.IMecDiagService;
import com.taller.utils.MecDiagMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MecDiagServiceImpl implements IMecDiagService {

    MecDiagRepository repository;
    MecanicoRepository mecanicoRepository;

    public MecDiagServiceImpl(MecDiagRepository repository, MecanicoRepository mecanicoRepository) {
        this.repository = repository;
        this.mecanicoRepository = mecanicoRepository;
    }

    @Override
    public Set<ResponseMecDiagDto> findAllMecDiag() {
        List<MecDiag> listaTematicas = repository.findAll();
        List<ResponseMecDiagDto> lista = MecDiagMapper.listaMecDiag(listaTematicas);
        return new HashSet<>(lista);
    }

    @Override
    public ResponseMecDiagDto findById(Long id) {
        MecDiag mecDiag = repository.findById(id).orElseThrow(
                () -> new GenericException("MecDiag Not found", HttpStatus.NOT_FOUND)
        );
        return MecDiagMapper.getMecanico(mecDiag);
    }

    @Override
    public ResponseDto save(MecDiagRequestDto mecdiag) {
        MecDiag response = MecDiagMapper.getMecDiag(mecdiag);
        Mecanico mecanico = mecanicoRepository.findById(mecdiag.getIdMecanico()).orElseThrow(
                () -> new GenericException("Mecánico not found", HttpStatus.NOT_FOUND)
        );
        response.setMecanico(mecanico);
        repository.save(response);
        return new ResponseDto("Se ha guardado con éxito");
    }

    @Override
    public ResponseDto update(MecDiagRequestDto mecDto, Long id) {
        MecDiag mecDiag = repository.findById(id).orElseThrow(
                ()-> new GenericException("MecDiag not found", HttpStatus.NOT_FOUND)
        );
        Mecanico mecanico = mecanicoRepository.findById(mecDto.getIdMecanico()).orElseThrow(
                () -> new GenericException("Mecánico not found", HttpStatus.NOT_FOUND)
        );
        MecDiag modificado = new MecDiag();
        modificado.setId(mecDiag.getId());
        modificado.setTematica(mecDto.getTematica());
        modificado.setMecanico(mecanico);
        MecDiag m = repository.save(modificado);
        return new ResponseDto("Modificación realizada con éxito");
    }

    @Override
    public ResponseDto delete(Long id) {
        MecDiag mecDiag = repository.findById(id).orElseThrow(
                ()-> new GenericException("MecDiag not found", HttpStatus.NOT_FOUND)
        );
        repository.deleteById(mecDiag.getId());
        return new ResponseDto("Eliminado con éxito");
    }
}
