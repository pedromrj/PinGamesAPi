package pingamesapi.controller.exceptions;

import java.util.List;

public class Validacao extends PadraoError{
	
	List<ErrorValidacao> errors;	
	
	public Validacao(Integer status,String msg,Long timestamp) {
		super(status,msg,timestamp);
	}
	
	public List<ErrorValidacao>getErros() {
		return errors;
	}
	
	public void addError(ErrorValidacao err) {
		errors.add(err);
	}
	
	public void setErrors(List<ErrorValidacao> error) {
		errors = error;
	}

}
