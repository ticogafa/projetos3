package com.example.rea4e.domain.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoResourcesFoundException extends RuntimeException {
    public NoResourcesFoundException(String message) {
        super(message);
    }

}
