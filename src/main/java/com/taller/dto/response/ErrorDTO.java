package com.taller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorDTO {

    private LocalDateTime date;
    private String message;
    private String description;
}
