package com.taller.exceptions;

import com.taller.dto.response.ErrorDTO;
import com.taller.errors.ExceptionController;
import com.taller.errors.GenericException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExceptionTest {

    @Autowired
    ExceptionController controller;

    @Test
    @DisplayName("Test OK para GenericException")
    void genericExceptionTestOK(){
        GenericException argumentSut = new GenericException("Excepcion Lanzada", HttpStatus.NOT_FOUND);
        ErrorDTO errorDTO = new ErrorDTO(LocalDate.of(2024,7,22),
                "Excepcion Lanzada");
        ResponseEntity<?> expected = new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);

        ResponseEntity<?> actual = controller.genericCustomException(argumentSut);

        assertEquals(expected, actual);
    }
}
