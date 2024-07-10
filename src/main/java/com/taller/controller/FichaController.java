package com.taller.controller;

import com.taller.dto.request.FichaRequestDto;
import com.taller.services.IFichaService;
import com.taller.services.impl.FichaServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ficha")
@Validated
public class FichaController {

    IFichaService service;

    public FichaController(FichaServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFichaById(@PathVariable @Positive(message = "Debe ser un número positivo") Long id){
        return new ResponseEntity<>(service.getFichaById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveFicha(@RequestBody @Valid FichaRequestDto fichaDto){
        return new ResponseEntity<>(service.saveFicha(fichaDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFicha(@PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.deleteFicha(id), HttpStatus.OK);
    }
}
