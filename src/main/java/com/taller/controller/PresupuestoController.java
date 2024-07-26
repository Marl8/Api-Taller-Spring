package com.taller.controller;

import com.taller.dto.request.PresupuestoRequestDto;
import com.taller.services.IPresupuestoService;
import com.taller.services.impl.PresupuestoServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/presupuesto")
@Validated
@PreAuthorize("authentication")
public class PresupuestoController {

    IPresupuestoService service;

    public PresupuestoController(PresupuestoServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<?> findAllPresupuestos() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<?> findByIdPresupuesto(@PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('CREATED')")
    public ResponseEntity<?> savePresupuesto(@RequestBody @Valid PresupuestoRequestDto p) {
        return new ResponseEntity<>(service.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<?> updatePresupuesto(@RequestBody @Valid PresupuestoRequestDto p,
                                               @PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.update(p,id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<?> deletePresupuesto(@RequestParam @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}