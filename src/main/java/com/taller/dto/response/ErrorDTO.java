package com.taller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class ErrorDTO {

    private LocalDate date;
    private String message;
}
