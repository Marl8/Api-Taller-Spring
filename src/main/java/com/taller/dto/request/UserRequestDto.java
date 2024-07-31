package com.taller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDto {

    @NotBlank(message = "Username es requerido")
    private String username;
    @NotBlank(message = "Password es requerido")
    private String password;
}
