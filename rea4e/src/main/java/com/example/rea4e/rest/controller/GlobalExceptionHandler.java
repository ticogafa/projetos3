package com.example.rea4e.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.rea4e.domain.exception.*;

import jakarta.persistence.EntityNotFoundException;

/*
 * Essa classe é responsáveis por tratar as exceções lançadas pela aplicação e traduzir nos codigos de status HTTP corretos
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(CourseNotFoundInSubscribedListException.class)
    public ResponseEntity<String> handleCourseNotFoundInSubscribedListException(CourseNotFoundInSubscribedListException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceAlreadyFinishedException.class)           //ReourceAlreadyFinishedException
    public ResponseEntity<String> handleResourceAlreadyFinishedException(ResourceAlreadyFinishedException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceAlreadyAddedException.class)
    public ResponseEntity<String> handleResourceAlreadyAddedException(ResourceAlreadyAddedException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceAlreadyFavoritedException.class)
    public ResponseEntity<String> handleResourceAlreadyFavoritedException(ResourceAlreadyFavoritedException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotPresentInConcludedException.class)
    public ResponseEntity<String> handleResourceNotPresentInConcludedException(ResourceNotPresentInConcludedException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotPresentInFavouritesException.class)
    public ResponseEntity<String> handleResourceNotPresentInFavouritesException(ResourceNotPresentInFavouritesException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UserAlreadySubscribedException.class)
    public ResponseEntity<String> handleUserAlreadySubscribedException(UserAlreadySubscribedException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
