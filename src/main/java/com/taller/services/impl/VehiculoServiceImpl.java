package com.taller.services.impl;

import com.taller.dto.request.VehiculoRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseVehiculoDto;
import com.taller.entity.Cliente;
import com.taller.entity.Vehiculo;
import com.taller.repository.ClienteRepository;
import com.taller.repository.VehiculoRepository;
import com.taller.services.IVehiculoService;
import com.taller.utils.VehiculoMapper;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    VehiculoRepository repository;
    ClienteRepository clienteRepository;

    public VehiculoServiceImpl(VehiculoRepository repository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }


    @Override
    public Set<ResponseVehiculoDto> findAllVehiculos() {
        List<Vehiculo> listaVehiculos = repository.findAll();
        List<ResponseVehiculoDto> lista = VehiculoMapper.listaVehiculos(listaVehiculos);
        return new HashSet<>(lista);
    }

    @Override
    public ResponseVehiculoDto findById(Long id) {
        Vehiculo vehiculo = repository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Vehiculo not found")
        );
        return VehiculoMapper.vehiculoDto(vehiculo);
    }

    @Override
    public ResponseDto save(VehiculoRequestDto vDto) {
        Optional<Vehiculo> existe = repository.findVehiculoByMatricula(vDto.getMatricula());
        if(existe.isPresent()){
            throw new IllegalStateException("El vehículo ya existe");
        }
        Cliente cliente = clienteRepository.findById(vDto.getIdCliente()).orElseThrow(
                ()-> new IllegalStateException("Cliente not found")
        );
        Vehiculo vehiculo = VehiculoMapper.vehiculo(vDto);
        vehiculo.setCliente(cliente);
        repository.save(vehiculo);
        return new ResponseDto("Vehiculo guardado con éxito");
    }

    @Override
    public ResponseDto updateVehiculos(Long id, VehiculoRequestDto vDto) {
        Vehiculo vehiculo = repository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Vehiculo not found")
        );
        Cliente cliente = clienteRepository.findById(vDto.getIdCliente()).orElseThrow(
                ()-> new IllegalStateException("Cliente not found")
        );
        Vehiculo modificado = new Vehiculo();
        modificado.setId(vehiculo.getId());
        modificado.setMatricula(vDto.getMatricula());
        modificado.setMarca(vDto.getMarca());
        modificado.setModelo(vDto.getModelo());
        modificado.setColor(vDto.getColor());
        modificado.setCliente(cliente);
        repository.save(modificado);
        return new ResponseDto("Vehículo modificado con éxito");
    }

    @Override
    public ResponseDto delete(Long id) {
        Vehiculo vehiculo = repository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Vehiculo not found")
        );
        repository.deleteById(vehiculo.getId());
        return new ResponseDto("Vehículo eliminado con éxito");
    }
}
