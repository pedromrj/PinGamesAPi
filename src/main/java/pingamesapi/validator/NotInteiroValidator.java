package pingamesapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pingamesapi.annotations.NotInteiro;

public class NotInteiroValidator implements ConstraintValidator<NotInteiro, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		char[] letra = value.toCharArray();
		for (int i = 0; i < letra.length; i++) {
			if(Character.isDigit(letra[i])) {
				return false;
			}
		}
		return true; 
	}

}
