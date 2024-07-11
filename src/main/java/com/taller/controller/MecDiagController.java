package com.taller.controller;

import com.taller.dto.request.MecDiagRequestDto;
import com.taller.services.IMecDiagService;
import com.taller.services.impl.MecDiagServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mecdiag")
@Validated
public class MecDiagController {

    IMecDiagService service;

    public MecDiagController(MecDiagServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAllMecDiag() {
        return new ResponseEntity<>(service.findAllMecDiag(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findMecDiagById(@PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMecDiag(@RequestBody @Valid MecDiagRequestDto mecdiag) {
        return new ResponseEntity<>(service.save(mecdiag), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateMecDiag(@RequestBody @Valid MecDiagRequestDto mecdiag,
                                           @PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.update(mecdiag, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMecDiag(@PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}