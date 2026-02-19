package com.soham.airbnb.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestController//Global Exception Handler for REST API
public class GlobalExceptionHandler {

    public ResponseEntity<ErrorResponse> handleNotFound(
            ResoucreNotFoundException ex,
            //What does HttpServletResponse Does?
            // Status code
            // Response headers
            // Cookies
            // Redirects
            // Output stream (raw response body)
            HttpServletRequest request){

        ErrorResponse error =new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                ex.getMessage(),
                request.getRequestURI()

        );
        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<ErrorResponse> handleBadRequest(
            BadRequestException ex,
            HttpServletRequest request

    ){
        ErrorResponse  error = new ErrorResponse(
               LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error Occured",
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error ,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String >> handleValidationErrors (
            MethodArgumentNotValidException ex
    ){
        Map<String ,String > errors =new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> errors.put(e.getField() ,e.getDefaultMessage()));


        return new ResponseEntity<>(errors ,HttpStatus.BAD_REQUEST);
    }


}

