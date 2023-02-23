package com.portal.payroll.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PayrollInfoControllerAdvice {

    @ExceptionHandler(PayrollInfoException.class)
    public ResponseEntity<String> payrollInfoPortalExceptionHandler(Exception ex){
        return new ResponseEntity<>("Error occurred: "+ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> generalExceptionHandler(Exception ex){
        return new ResponseEntity<>("Error occurred: "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
