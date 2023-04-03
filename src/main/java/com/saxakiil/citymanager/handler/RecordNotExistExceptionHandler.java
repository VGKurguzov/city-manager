package com.saxakiil.citymanager.handler;

import com.saxakiil.citymanager.dto.ErrorDto;
import com.saxakiil.citymanager.exception.RecordNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class RecordNotExistExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotExistException.class)
    protected ResponseEntity<ErrorDto> handlerRecordNotFound(RecordNotExistException e, WebRequest request) {
        log.error(e.getMessage());
        return new ResponseEntity<>(new ErrorDto(HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(), ((ServletWebRequest) request).getRequest().getRequestURI(),
                e.getMessage(), LocalDateTime.now().toString()), HttpStatus.NOT_FOUND);
    }
}
