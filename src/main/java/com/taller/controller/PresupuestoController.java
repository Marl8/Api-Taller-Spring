package com.taller.controller;

import com.taller.dto.request.PresupuestoRequestDto;
import com.taller.services.IPresupuestoService;
import com.taller.services.impl.PresupuestoServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/presupuesto")
@Validated
public class PresupuestoController {

    IPresupuestoService service;

    public PresupuestoController(PresupuestoServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable @Positive(message = "Debe ser un número positivo") Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePresupuesto(@RequestBody @Valid PresupuestoRequestDto p) {
        return new ResponseEntity<>(service.save(p), HttpStatus.OK);
    }
}
