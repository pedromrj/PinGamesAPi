package pingamesapi.service.exceptions;

import java.util.ArrayList;
import java.util.List;

import pingamesapi.controller.exceptions.ErrorValidacao;

public class ValidacaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private List<ErrorValidacao> err = new ArrayList<ErrorValidacao>();
	
	public ValidacaoException(List<ErrorValidacao> erros,String msg) {
		super(msg);
		err = erros;
	}

	public List<ErrorValidacao> getErros() {
		return err;
	}

	public void setErros(List<ErrorValidacao> err) {
		this.err = err;
	}
	
}
