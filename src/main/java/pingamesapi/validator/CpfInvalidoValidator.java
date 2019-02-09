package pingamesapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pingamesapi.annotations.CPFValidator;
import pingamesapi.service.utils.CpfAndCnpj;

public class CpfInvalidoValidator implements ConstraintValidator<CPFValidator, String>{
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return CpfAndCnpj.ValidCpf(value);
	}

}
