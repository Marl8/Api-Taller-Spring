package com.taller.controller;

import com.taller.dto.request.UserRequestDto;
import com.taller.services.IUserEntityService;
import com.taller.services.impl.UserEntityServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserEntityController {

    IUserEntityService service;

    public UserEntityController(UserEntityServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('CREATED')")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserRequestDto userDto) {
        return new ResponseEntity<>(service.createUser(userDto), HttpStatus.CREATED);
    }


}
