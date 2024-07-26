package com.taller.controller;

import com.taller.dto.request.VehiculoRequestDto;
import com.taller.services.IVehiculoService;
import com.taller.services.impl.VehiculoServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehiculo")
@Validated
@PreAuthorize("authentication")
public class VehiculoController {

    IVehiculoService service;

    public VehiculoController(VehiculoServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<?> findAllVehiculos() {
        return new ResponseEntity<>(service.findAllVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<?> findVehiculosById(@PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('CREATED')")
    public ResponseEntity<?> saveVehiculo(@RequestBody @Valid VehiculoRequestDto vDto) {
        return new ResponseEntity<>(service.save(vDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<?> updateVehiculos(@PathVariable @Positive(message = "Debe ser un número positivo") Long id, @RequestBody @Valid VehiculoRequestDto vDto) {
        return new ResponseEntity<>(service.updateVehiculos(id, vDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<?> deleteVehiculos(@RequestParam @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}