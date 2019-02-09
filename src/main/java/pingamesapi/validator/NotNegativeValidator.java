package pingamesapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pingamesapi.annotations.NotNegativo;

public class NotNegativeValidator implements ConstraintValidator<NotNegativo, Double>{

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		return value < 0;
	}

}
