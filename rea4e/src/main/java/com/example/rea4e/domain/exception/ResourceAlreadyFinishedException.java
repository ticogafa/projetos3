package com.example.rea4e.domain.exception;

public class ResourceAlreadyFinishedException extends RuntimeException {
    public ResourceAlreadyFinishedException(String message) {
        super(message);
    }

}
