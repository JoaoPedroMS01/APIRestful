package org.serratec.projeto.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptoinHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmailException.class)
	protected ResponseEntity<Object> handleEmailExceptoin(EmailException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	@ExceptionHandler(SenhaException.class)
	protected ResponseEntity<Object> handleEmailExceptoin(SenhaException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

}
