package com.taller.controller;

import com.taller.dto.request.MecRepRequestDto;
import com.taller.entity.Mecanico;
import com.taller.services.IMecRepService;
import com.taller.services.impl.MecRepServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mecRep")
@Validated
public class MecRepController {

    IMecRepService service;

    public MecRepController(MecRepServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable @Positive(message = "Debe ser un número positivo")Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMecRep(@RequestBody @Valid MecRepRequestDto mecDto){
        return new ResponseEntity<>(service.saveMecRep(mecDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid MecRepRequestDto mecDto,
            @PathVariable @Positive(message = "Debe ser un número positivo")Long id){
        return new ResponseEntity<>(service.update(mecDto,id), HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestParam @Positive(message = "Debe ser un número positivo")Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
