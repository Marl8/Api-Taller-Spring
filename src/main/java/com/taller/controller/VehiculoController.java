package com.taller.controller;

import com.taller.dto.request.VehiculoRequestDto;
import com.taller.services.IVehiculoService;
import com.taller.services.impl.VehiculoServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehiculo")
@Validated
public class VehiculoController {

    IVehiculoService service;

    public VehiculoController(VehiculoServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllVehiculos() {
        return new ResponseEntity<>(service.findAllVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findVehiculosById(@PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveVehiculo(@RequestBody @Valid VehiculoRequestDto vDto) {
        return new ResponseEntity<>(service.save(vDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVehiculos(@PathVariable @Positive(message = "Debe ser un número positivo") Long id, @RequestBody @Valid VehiculoRequestDto vDto) {
        return new ResponseEntity<>(service.updateVehiculos(id, vDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteVehiculos(@RequestParam @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}