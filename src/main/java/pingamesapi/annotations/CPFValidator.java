package pingamesapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pingamesapi.validator.CpfInvalidoValidator;

@Constraint(validatedBy = CpfInvalidoValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFValidator {

	String message() default "CPF INVALIDO";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
