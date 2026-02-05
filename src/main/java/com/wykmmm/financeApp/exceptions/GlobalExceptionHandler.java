package com.wykmmm.financeApp.exceptions;

import com.wykmmm.financeApp.exceptions.userExceptions.EmailAlreadyInUseException;
import com.wykmmm.financeApp.exceptions.userExceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(
            Exception exception,
            WebRequest request
    ){
        return buildErrorResponse(exception,HttpStatus.INTERNAL_SERVER_ERROR,request);
    }


    @ExceptionHandler(EmailAlreadyInUseException.class)
    public ResponseEntity<Object> handleEmailAlreadyInUseException(
            EmailAlreadyInUseException exception,
            WebRequest request
    ){
        return buildErrorResponse(exception,HttpStatus.BAD_REQUEST,request);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(
            UserNotFoundException exception,
            WebRequest request
    ){
        return buildErrorResponse(exception,HttpStatus.NOT_FOUND,request);
    }

    private ResponseEntity<Object> buildErrorResponse(
            Exception ex, HttpStatus status, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, status);
    }
}
