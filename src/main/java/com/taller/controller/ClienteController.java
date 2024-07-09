package com.taller.controller;

import com.taller.services.IClienteService;
import com.taller.services.impl.ClienteServiceImpl;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cliente")
@Validated
public class ClienteController {

    IClienteService service;

    public ClienteController(ClienteServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getClientes(){
      return new ResponseEntity<>(service.getClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable @Positive(message = "Debe ser un número positivo") Long id){
        return new ResponseEntity<>(service.getClient(id), HttpStatus.OK);
    }
}
