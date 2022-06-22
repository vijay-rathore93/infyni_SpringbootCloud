package org.application.exception;

import org.application.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse> handlingOrderException(OrderException orderException){
        return new ResponseEntity<>(ErrorResponse
                .builder()
                .message(orderException.getErrorMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlingException(Exception exception){
        return new ResponseEntity<>(ErrorResponse
                .builder()
                .message(exception.getLocalizedMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
