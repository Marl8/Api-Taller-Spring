package com.taller.controller;

import com.taller.services.IVehiculoService;
import com.taller.services.impl.VehiculoServiceImpl;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehiculo")
@Validated
public class VehiculoController {

    IVehiculoService service;

    public VehiculoController(VehiculoServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAllVehiculos(){
        return new ResponseEntity<>(service.findAllVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findVehiculosById(@PathVariable @Positive(message = "Debe ser un número positivo") Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
}
