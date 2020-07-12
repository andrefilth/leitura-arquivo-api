package com.br.filereader.restapi;

import com.br.filereader.infra.exception.Errors;
import com.br.filereader.infra.exception.FileInvalidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@Slf4j
@RestControllerAdvice
class ControllerAdvice {


    @ExceptionHandler(FileInvalidException.class)
    @ResponseStatus(BAD_REQUEST)
    public Errors handleValidationException(FileInvalidException ex){
        return new Errors(ex);
    }


}
