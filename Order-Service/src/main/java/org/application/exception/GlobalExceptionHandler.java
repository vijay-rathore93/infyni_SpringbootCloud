package org.application.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.vijayCode.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse> handlingOrderException(OrderException orderException){
        return new ResponseEntity<>(getErrorResponse(orderException.getErrorMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlingException(Exception exception){
        return new ResponseEntity<>(getErrorResponse(exception.getLocalizedMessage()),
                HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse getErrorResponse(String errorMessage ) {
        ErrorResponse errorResponse=  new ErrorResponse();
        errorResponse.setMessage(errorMessage);
        errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
        return errorResponse;
    }
}
