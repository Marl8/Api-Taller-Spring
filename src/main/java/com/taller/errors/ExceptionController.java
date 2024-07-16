package com.taller.errors;

import com.taller.dto.response.ErrorValidDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<?> genericCustomException(GenericException ex){
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> fallanVariasValidaciones(MethodArgumentNotValidException ex){

        HashMap<String, String> errores = new HashMap<>();
        ex.getFieldErrors()
                .forEach(field -> errores.put(field.getField(), field.getDefaultMessage()));

        return new ResponseEntity<>(new ErrorValidDTO(400, errores), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> genericException (Exception ex, HttpServletRequest req){
        Map<String, String> apiError = new HashMap<>();
        apiError.put("message", ex.getLocalizedMessage());
        apiError.put("timestamp", new Date().toString());
        apiError.put("url" , req.getRequestURL().toString());
        apiError.put("http-method", req.getMethod());

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if(ex instanceof AccessDeniedException){
            status = HttpStatus.FORBIDDEN;
        }
        return ResponseEntity.status(status).body(apiError);
    }
}
