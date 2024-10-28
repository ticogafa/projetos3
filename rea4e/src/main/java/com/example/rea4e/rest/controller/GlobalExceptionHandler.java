package com.example.rea4e.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.rea4e.domain.exception.NoResourcesFoundException;

import jakarta.persistence.EntityNotFoundException;

//Escrever @ControllerAdvice é o mesmo que escrever @Component, mas com a semântica de que é um componente que vai tratar exceções, tambem inclui @ResponseBody e @ExceptionHandler em todos os métodos
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        // Retorna 404 Not Found com a mensagem da exceção
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        // Retorna 400 Bad Request com a mensagem da exceção
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(NoResourcesFoundException.class)
    public ResponseEntity<String> handleNoResourcesFoundException(NoResourcesFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}