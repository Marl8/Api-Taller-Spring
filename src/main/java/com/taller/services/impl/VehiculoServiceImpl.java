package com.taller.services.impl;

import com.taller.dto.request.VehiculoRequestDto;
import com.taller.dto.response.ResponseVehiculoDto;
import com.taller.entity.Vehiculo;
import com.taller.repository.VehiculoRepository;
import com.taller.services.IVehiculoService;
import com.taller.utils.VehiculoMapper;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    VehiculoRepository repository;

    public VehiculoServiceImpl(VehiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<VehiculoRequestDto> findAllVehiculos() {
        List<Vehiculo> listaVehiculos = repository.findAll();
        List<VehiculoRequestDto> lista = VehiculoMapper.listaVehiculos(listaVehiculos);
        return new HashSet<>(lista);
    }

    @Override
    public ResponseVehiculoDto findById(Long id) {
        Vehiculo vehiculo = repository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Vehiculo not found")
        );
        return VehiculoMapper.vehiculoDto(vehiculo);
    }
}
