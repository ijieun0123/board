package com.example.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException e){
        List<ObjectError> errors = e.getBindingResult().getAllErrors();

        StringBuilder errorMessages = new StringBuilder();

        for (ObjectError error : errors){
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errorMessages.append(fieldName).append(": ").append(message).append("\n");
        }

        return new ResponseEntity<>(errorMessages.toString(), HttpStatus.BAD_REQUEST);
    }

}
