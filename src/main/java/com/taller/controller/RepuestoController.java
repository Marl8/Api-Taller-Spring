package com.taller.controller;

import com.taller.dto.request.RepuestoRequestDto;
import com.taller.services.IRepuestoService;
import com.taller.services.impl.RepuestoServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public ResponseEntity<?> saveRepuesto(@RequestBody @Valid RepuestoRequestDto rDto){
        return new ResponseEntity<>(service.save(rDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRepuesto(@RequestBody @Valid RepuestoRequestDto r,
                                               @PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.update(r,id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRepuesto(@RequestParam @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
