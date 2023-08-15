package com.sik.template.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public ErrorResult illegalEx(IllegalArgumentException e){
        log.error("exhanlder ={}",e);
        return new ErrorResult("BAD",e.getMessage());
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResult> userEx(UserException e){
        log.error("ex hanlder ={}",e);
        ErrorResult errorResult = new ErrorResult("user=ex", e.getMessage());

        return new ResponseEntity<>(errorResult,HttpStatus.BAD_REQUEST);
    }
}
