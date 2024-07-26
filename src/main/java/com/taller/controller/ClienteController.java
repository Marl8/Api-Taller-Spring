package com.taller.controller;

import com.taller.dto.request.ClienteRequestDto;
import com.taller.dto.request.ClienteUpdateDto;
import com.taller.services.IClienteService;
import com.taller.services.impl.ClienteServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cliente")
@Validated
@PreAuthorize("hasRole('ADMIN')")
public class ClienteController {

    IClienteService service;

    public ClienteController(ClienteServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<?> getClientes(){
      return new ResponseEntity<>(service.getClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ') or hasAuthority('CREATED') ")
    public ResponseEntity<?> getCliente(@PathVariable @Positive(message = "Debe ser un número positivo") Long id){
        return new ResponseEntity<>(service.getClient(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('CREATED')")
    public ResponseEntity<?> saveCliente(@RequestBody @Valid ClienteRequestDto clienteDto){
        return new ResponseEntity<>(service.saveCliente(clienteDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<?> updateCliente(@PathVariable @Positive(message = "Debe ser un número positivo") Long id,
                                           @RequestBody ClienteUpdateDto clienteDto){
        return new ResponseEntity<>(service.updateCliente(id, clienteDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<?> deleteCliente(@PathVariable @Positive(message = "Debe ser un número positivo") Long id){
        return new ResponseEntity<>(service.deleteCliente(id), HttpStatus.OK);
    }
}
