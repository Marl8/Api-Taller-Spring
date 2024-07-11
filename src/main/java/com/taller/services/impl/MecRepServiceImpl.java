package com.taller.services.impl;

import com.taller.dto.request.MecRepRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseMecRepDto;
import com.taller.entity.MecRep;
import com.taller.entity.Mecanico;
import com.taller.repository.MecRepRepository;
import com.taller.repository.MecanicoRepository;
import com.taller.services.IMecRepService;
import com.taller.utils.MecRepMapper;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MecRepServiceImpl implements IMecRepService {

    MecRepRepository repository;
    MecanicoRepository mecanicoRepository;

    public MecRepServiceImpl(MecRepRepository repository, MecanicoRepository mecanicoRepository) {
        this.repository = repository;
        this.mecanicoRepository = mecanicoRepository;
    }

    @Override
    public Set<ResponseMecRepDto> findAll() {
        List<MecRep> result = repository.findAll();
        List<ResponseMecRepDto> lista = MecRepMapper.listaMecRepDto(result);
        return new HashSet<>(lista);
    }

    @Override
    public ResponseMecRepDto findById(Long id) {
        MecRep mec = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("MecRep not found")
        );
        return MecRepMapper.mecRepDto(mec);
    }

    @Override
    public ResponseDto saveMecRep(MecRepRequestDto mecDto) {
        MecRep mec = MecRepMapper.mecRep(mecDto);
        Mecanico mecanico = mecanicoRepository.findById(mecDto.getIdMecanico()).orElseThrow(
                () -> new RuntimeException("Mecánico not found")
        );
        mec.setMecanico(mecanico);
        repository.save(mec);
        return new ResponseDto("Guardado con éxito");
    }

    @Override
    public ResponseDto update(MecRepRequestDto mecRepDto, Long id) {
        MecRep mec = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("MecRep not found")
        );
        Mecanico mecanico = mecanicoRepository.findById(mecRepDto.getIdMecanico()).orElseThrow(
                () -> new RuntimeException("Mecánico not found")
        );
        MecRep modificado = new MecRep();
        modificado.setId(mec.getId());
        modificado.setHoraEntrada(mec.getHoraEntrada());
        modificado.setHoraSalida(mec.getHoraSalida());
        modificado.setMecanico(mecanico);
        repository.save(modificado);
        return new ResponseDto("Modificado con éxito");
    }

    @Override
    public ResponseDto delete(Long id) {
        MecRep mec = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("MecRep not found")
        );
        repository.deleteById(mec.getId());
        return new ResponseDto("Eliminado con éxito");
    }

}
