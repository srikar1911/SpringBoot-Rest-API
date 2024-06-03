package com.BootRestProj07.advice;

import com.BootRestProj07.error.ErrorDetails;
import com.BootRestProj07.exception.DoctorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class DoctorServiceErrorHandlerAdvice {
    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ErrorDetails> handelDoctorNotFound(DoctorNotFoundException dnfe){
        ErrorDetails details = new ErrorDetails();
        details.setTime(LocalDateTime.now());
        details.setMessage(dnfe.getMessage());
        details.setStatus("404 - Doctor Not Found");
        return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handelDoctorNotFound(Exception e){
        ErrorDetails details = new ErrorDetails();
        details.setTime(LocalDateTime.now());
        details.setMessage(e.getMessage());
        details.setStatus("500 - Internal Server Error");
        return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
    }

}
