package pingamesapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pingamesapi.annotations.CNPJValidator;
import pingamesapi.service.utils.CpfAndCnpj;

public class CnpjInvalidoValidator implements ConstraintValidator<CNPJValidator, String>{
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return CpfAndCnpj.validCnpj(value);
	}

}
