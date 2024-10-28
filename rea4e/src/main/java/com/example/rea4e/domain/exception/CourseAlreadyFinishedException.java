package com.example.rea4e.domain.exception;

public class CourseAlreadyFinishedException extends RuntimeException {
    public CourseAlreadyFinishedException(String message) {
        super(message);
    }

}
