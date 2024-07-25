package com.taller.controller;

import com.taller.dto.request.RepuestoRequestDto;
import com.taller.services.IRepuestoService;
import com.taller.services.impl.RepuestoServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('READ') or hasAuthority('CREATED')")
    public ResponseEntity<?> findAllRespuestos() {
        return new ResponseEntity<>(service.findAllRespuestos(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    @PreAuthorize("hasAuthority('READ') or hasAuthority('CREATED')")
    public ResponseEntity<?> findByIdRepuesto(@PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('CREATED')")
    public ResponseEntity<?> saveRepuesto(@RequestBody @Valid RepuestoRequestDto rDto){
        return new ResponseEntity<>(service.save(rDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('CREATED')")
    public ResponseEntity<?> updateRepuesto(@RequestBody @Valid RepuestoRequestDto r,
                                               @PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.update(r,id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('CREATED')")
    public ResponseEntity<?> deleteRepuesto(@RequestParam @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
