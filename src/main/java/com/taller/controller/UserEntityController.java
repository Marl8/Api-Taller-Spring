package com.taller.controller;

import com.taller.dto.request.UserEntityAuthRequestDto;
import com.taller.dto.request.UserEntityUpdateRequestDto;
import com.taller.dto.request.UserRequestDto;
import com.taller.services.IUserEntityService;
import com.taller.services.impl.UserEntityServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Validated
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

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserEntityUpdateRequestDto userDto,
                                        @PathVariable @Positive(message = "Id debe ser un número positivo")Long id){
        return new ResponseEntity<>(service.updateUser(userDto,id), HttpStatus.OK);
    }

    @PutMapping("/updateAuthorities/{idUser}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<?> updateAuthorities(@RequestBody @Valid UserEntityAuthRequestDto userDto,
                                        @PathVariable @Positive(message = "Id debe ser un número positivo")Long idUser){
        return new ResponseEntity<>(service.updateAuthorties(userDto,idUser), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<?> deleteUser(@RequestParam @Positive(message = "Debe ser un número positivo")Long id){
        return new ResponseEntity<>(service.deleteUser(id), HttpStatus.OK);
    }
}
