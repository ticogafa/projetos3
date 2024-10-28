package com.example.rea4e.domain.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


public class ResourceAlreadyAddedException extends RuntimeException {
    public ResourceAlreadyAddedException(String message) {
        super(message);
    }
}