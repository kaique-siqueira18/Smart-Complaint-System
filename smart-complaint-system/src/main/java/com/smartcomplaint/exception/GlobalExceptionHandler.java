package com.smartcomplaint.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice // interpreta erro da APLICACAO INTEIRA
public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)// RETORNA 404
public String handlerNotFound(ResourceNotFoundException ex) {
	return ex.getMessage();
}
}
