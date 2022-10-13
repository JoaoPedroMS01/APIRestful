package org.serratec.exercicio01.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErroResposta er = new ErroResposta(status.value(), "Existem campos inválidos", LocalDateTime.now());
		
		List<String> erros = new ArrayList<>();
		for(FieldError fe : ex.getFieldErrors()) {
			erros.add(fe.getField() + ": " + fe.getDefaultMessage());
		}
		er.setErros(erros);
		
		return super.handleExceptionInternal(ex, er, headers, status, request);
	}
	
}
