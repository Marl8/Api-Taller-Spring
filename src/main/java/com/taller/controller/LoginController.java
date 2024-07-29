package com.taller.controller;

import com.taller.dto.request.LoginDto;
import com.taller.services.ILoginService;
import com.taller.services.impl.LoginServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    ILoginService service;

    public LoginController(LoginServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> login (@Valid @RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(service.login(loginDto), HttpStatus.OK);
    }
}
