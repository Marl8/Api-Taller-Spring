package com.taller.controller;

import com.taller.services.IRepuestoService;
import com.taller.services.impl.RepuestoServiceImpl;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/repuesto")
@Validated
public class RepuestoController {

    IRepuestoService service;

    public RepuestoController(RepuestoServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAllRespuestos() {
        return new ResponseEntity<>(service.findAllRespuestos(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findByIdRepuesto(@PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
}
