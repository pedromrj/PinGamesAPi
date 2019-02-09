package pingamesapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pingamesapi.validator.NotNegativeValidator;

@Constraint(validatedBy = NotNegativeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNegativo {
	
	String message() default "O valor nao pode ser negativo!";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default {};

}
