package pingamesapi.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pingamesapi.service.exceptions.LibraryHasGameException;
import pingamesapi.service.exceptions.ObjectNotFoundException;
import pingamesapi.service.exceptions.ValidacaoException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<PadraoError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		PadraoError error = new PadraoError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(ValidacaoException.class)
	public ResponseEntity<Validacao> errorValidacao(ValidacaoException e, HttpServletRequest request) {
		Validacao error = new Validacao(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
		error.setErrors(e.getErros());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Validacao> notValidException(MethodArgumentNotValidException e, HttpServletRequest request){
		Validacao err = new Validacao(HttpStatus.BAD_REQUEST.value(),"ERRO DE VALIDACAO !!",System.currentTimeMillis());
		List<ErrorValidacao> erros = new ArrayList<ErrorValidacao>();
		for (FieldError error : e.getBindingResult().getFieldErrors()) {
			erros.add(new ErrorValidacao(error.getField(),error.getDefaultMessage()));
		}
		err.setErrors(erros);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(LibraryHasGameException.class)
	public ResponseEntity<PadraoError> libraryHasGame(LibraryHasGameException e, HttpServletRequest request) {
		PadraoError error = new PadraoError(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
