package com.taller.controller;

import com.taller.dto.request.FichaMdRequestDto;
import com.taller.dto.request.FichaRequestDto;
import com.taller.services.IFichaService;
import com.taller.services.impl.FichaServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ficha")
@Validated
@PreAuthorize("authentication")
public class FichaController {

    IFichaService service;

    public FichaController(FichaServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<?> getFichaById(@PathVariable @Positive(message = "Debe ser un número positivo") Long id){
        return new ResponseEntity<>(service.getFichaById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('CREATED')")
    public ResponseEntity<?> saveFicha(@RequestBody @Valid FichaRequestDto fichaDto){
        return new ResponseEntity<>(service.saveFicha(fichaDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<?> deleteFicha(@PathVariable @Positive(message = "Debe ser un número positivo") Long id) {
        return new ResponseEntity<>(service.deleteFicha(id), HttpStatus.OK);
    }

    @PostMapping("/informe")
    @PreAuthorize("hasAuthority('CREATED')")
    public ResponseEntity<?> informe(@RequestBody @Valid FichaMdRequestDto inform,
                                     @RequestParam @Positive(message = "Debe ser un número positivo") Long idFicha,
                                     @RequestParam @Positive(message = "Debe ser un número positivo") Long idMecDiag) {
        return new ResponseEntity<>(service.informe(inform, idFicha,idMecDiag),HttpStatus.OK);
    }
}
