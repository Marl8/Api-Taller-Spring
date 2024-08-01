package com.taller.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntityAuthRequestDto {

    @NotEmpty(message = "La lista no puede esta vacía")
    List<Long> roles;
}
