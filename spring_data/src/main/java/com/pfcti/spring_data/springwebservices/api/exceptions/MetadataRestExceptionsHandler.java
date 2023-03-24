package com.pfcti.spring_data.springwebservices.api.exceptions;

import com.pfcti.spring_data.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.pfcti.spring_data.springwebservices.api")
@Slf4j
public class MetadataRestExceptionsHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(Exception e) {
        return handleExceptionHandler(e);
    }

    public ResponseEntity<ErrorDTO> handleExceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        int codigo = 0;
        String message = e.getMessage();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorDTO(httpStatus.value(), codigo, message), httpStatus);
    }
}