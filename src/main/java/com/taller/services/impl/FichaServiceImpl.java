package com.taller.services.impl;

import com.taller.dto.request.FichaRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseGetFichaDto;
import com.taller.entity.Ficha;
import com.taller.entity.Vehiculo;
import com.taller.repository.FichaRepository;
import com.taller.repository.VehiculoRepository;
import com.taller.services.IFichaService;
import com.taller.utils.FichaMapper;
import org.springframework.stereotype.Service;

@Service
public class FichaServiceImpl implements IFichaService {

    FichaRepository repository;
    VehiculoRepository vehiculoRepository;

    public FichaServiceImpl(FichaRepository repository, VehiculoRepository vehiculoRepository) {
        this.repository = repository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public ResponseGetFichaDto getFichaById(Long id) {
        Ficha ficha = repository.findById(id).orElseThrow(
                () -> new IllegalStateException("Ficha not found")
        );
        return FichaMapper.getFicha(ficha);
    }

    @Override
    public ResponseDto saveFicha(FichaRequestDto fichaDto) {
        Vehiculo vehiculo = vehiculoRepository.findById(fichaDto.getVehiculoId()).orElseThrow(
                () -> new IllegalStateException("Vehiculo not found")
        );
        Ficha ficha = FichaMapper.ficha(fichaDto);
        ficha.setVehiculo(vehiculo);
        repository.save(ficha);
        return new ResponseDto("Ficha guardada con éxito");
    }

    @Override
    public ResponseDto deleteFicha(Long id) {
        Ficha encontrada = repository.findById(id).orElseThrow(
                () -> new IllegalStateException("Ficha not found")
        );
        repository.deleteById(encontrada.getId());
        return new ResponseDto("Ficha eliminada con éxito");
    }
}
