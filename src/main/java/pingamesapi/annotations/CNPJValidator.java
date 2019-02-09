package pingamesapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pingamesapi.validator.CnpjInvalidoValidator;

@Constraint(validatedBy = CnpjInvalidoValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CNPJValidator {

	String message() default "CNPJ INVALIDO";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
