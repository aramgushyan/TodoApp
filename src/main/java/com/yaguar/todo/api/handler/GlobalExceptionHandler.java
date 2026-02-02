package com.yaguar.todo.api.handler;

import com.yaguar.todo.api.dto.response.BadResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<BadResponse> handleNotFound(EntityNotFoundException exception) {
        BadResponse response = new BadResponse(HttpStatus.NOT_FOUND.value(),exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<BadResponse>> handleNotValid(MethodArgumentNotValidException exception) {
        var errors = exception.getAllErrors().stream().map((error)-> error.getDefaultMessage());

        var responses = errors
                .map((error)-> new BadResponse(HttpStatus.BAD_REQUEST.value(),error))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responses);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BadResponse> handleException(Exception exception) {
        BadResponse response = new BadResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
