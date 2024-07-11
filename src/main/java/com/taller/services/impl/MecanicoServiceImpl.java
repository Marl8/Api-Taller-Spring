package com.taller.services.impl;

import com.taller.dto.request.MecanicoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseMecanicoDto;
import com.taller.entity.Mecanico;
import com.taller.repository.MecanicoRepository;
import com.taller.services.IMecanicoService;
import com.taller.utils.MecanicoMapper;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MecanicoServiceImpl implements IMecanicoService {

    MecanicoRepository repository;

    public MecanicoServiceImpl(MecanicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<ResponseMecanicoDto> findAllMecanicos() {
        List<Mecanico> listaMecanicos = repository.findAll();
        List<ResponseMecanicoDto> lista = MecanicoMapper.listaMecanicos(listaMecanicos);
        return new HashSet<>(lista);
    }

    @Override
    public ResponseMecanicoDto findMecanicoById(Long id) {
        Mecanico mecanico = repository.findById(id).orElseThrow(
                () -> new IllegalStateException("Mecánico not found")
        );
        return MecanicoMapper.mecanicoDto(mecanico);
    }

    @Override
    public ResponseDto saveMecanico(MecanicoRequestDto mecanicoDto) {
        Optional<Mecanico> existe = repository.findMecanicoByDni(mecanicoDto.getDni());
        if (existe.isPresent()){
            throw new IllegalStateException("El mecánico ya existe");
        }
        Mecanico mecanico = MecanicoMapper.getMecanico(mecanicoDto);
        repository.save(mecanico);
        return new ResponseDto("Mecánico guardado con éxito");
    }

    @Override
    public ResponseDto updateMecanico(Long id, MecanicoRequestDto mecanicoDto) {
        Mecanico mecanico = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Mecánico not found")
        );
        Mecanico modificado = new Mecanico();
        modificado.setId(mecanico.getId());
        modificado.setNombre(mecanicoDto.getNombre());
        modificado.setApellido(mecanicoDto.getApellido());
        modificado.setDni(mecanicoDto.getDni());
        modificado.setTel(mecanicoDto.getTel());
        modificado.setRepara(mecanicoDto.isRepara());
        repository.save(modificado);
        return new ResponseDto("Mecánico modificado con éxito");
    }

    @Override
    public ResponseDto deleteMecanico(Long id) {
        Mecanico existe = repository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Mecánico Not found")
        );
        repository.deleteById(existe.getId());
        return new ResponseDto("Mecánico eliminado con éxito");
    }
}
