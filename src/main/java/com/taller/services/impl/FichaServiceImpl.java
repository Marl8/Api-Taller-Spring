package com.taller.services.impl;

import com.taller.dto.request.FichaMdRequestDto;
import com.taller.dto.request.FichaRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseGetFichaDto;
import com.taller.entity.Ficha;
import com.taller.entity.FichaMd;
import com.taller.entity.MecDiag;
import com.taller.entity.Vehiculo;
import com.taller.errors.GenericException;
import com.taller.repository.FichaMdRepository;
import com.taller.repository.FichaRepository;
import com.taller.repository.MecDiagRepository;
import com.taller.repository.VehiculoRepository;
import com.taller.services.IFichaService;
import com.taller.utils.FichaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class FichaServiceImpl implements IFichaService {

    FichaRepository repository;
    VehiculoRepository vehiculoRepository;
    FichaMdRepository fichaMdRepository;
    MecDiagRepository mecDiagRepository;

    public FichaServiceImpl(FichaRepository repository, VehiculoRepository vehiculoRepository,
                            MecDiagRepository mecDiagRepository, FichaMdRepository fichaMdRepository) {
        this.repository = repository;
        this.vehiculoRepository = vehiculoRepository;
        this.mecDiagRepository = mecDiagRepository;
        this.fichaMdRepository = fichaMdRepository;
    }

    @Override
    public ResponseGetFichaDto getFichaById(Long id) {
        Ficha ficha = repository.findById(id).orElseThrow(
                () -> new GenericException("Ficha not found", HttpStatus.NOT_FOUND)
        );
        return FichaMapper.getFicha(ficha);
    }

    @Override
    public ResponseDto saveFicha(FichaRequestDto fichaDto) {
        Vehiculo vehiculo = vehiculoRepository.findById(fichaDto.getVehiculoId()).orElseThrow(
                () -> new GenericException("Vehiculo not found", HttpStatus.NOT_FOUND)
        );
        Ficha ficha = FichaMapper.ficha(fichaDto);
        ficha.setVehiculo(vehiculo);
        repository.save(ficha);
        return new ResponseDto("Ficha guardada con éxito");
    }

    @Override
    public ResponseDto deleteFicha(Long id) {
        Ficha encontrada = repository.findById(id).orElseThrow(
                () -> new GenericException("Ficha not found", HttpStatus.NOT_FOUND)
        );
        repository.deleteById(encontrada.getId());
        return new ResponseDto("Ficha eliminada con éxito");
    }

    @Override
    public ResponseDto informe(FichaMdRequestDto inform, Long idFicha, Long idMecDiag) {
        Ficha ficha = repository.findById(idFicha).orElseThrow(
                ()-> new GenericException("Ficha not found", HttpStatus.NOT_FOUND)
        );
        MecDiag mecDiag = mecDiagRepository.findById(idMecDiag).orElseThrow(
                ()-> new GenericException("MecDiag not found", HttpStatus.NOT_FOUND)
        );
        FichaMd fichaMd = new FichaMd(ficha.getId(),mecDiag.getId(), inform.getInforme());
        fichaMdRepository.save(fichaMd);
        return new ResponseDto("Informe guardado con éxito");
    }

}
