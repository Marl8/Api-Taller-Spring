package com.taller.controller;

import com.taller.dto.request.MecanicoRequestDto;
import com.taller.services.IMecanicoService;
import com.taller.services.impl.MecanicoServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mecanico")
@Validated
public class MecanicoController {

    IMecanicoService service;

    public MecanicoController(MecanicoServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAllMecanicos(){
        return new ResponseEntity<>(service.findAllMecanicos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findMecanicoById(@PathVariable @Positive(message = "Debe ser un número positivo") Long id){
        return new ResponseEntity<>(service.findMecanicoById(id),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMecanico(@RequestBody @Valid MecanicoRequestDto mecanicoDto){
        return new ResponseEntity<>(service.saveMecanico(mecanicoDto),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMecanico(@PathVariable @Positive(message = "Debe ser un número positivo")Long id,
                                           @Valid @RequestBody MecanicoRequestDto mecanicoDto){
        return new ResponseEntity<>(service.updateMecanico(id, mecanicoDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteMecanico(@RequestParam @Positive(message = "Debe ser un número positivo") Long id){
        return new ResponseEntity<>(service.deleteMecanico(id),HttpStatus.OK);
    }
}
