package pingamesapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pingamesapi.validator.NotInteiroValidator;

@Constraint(validatedBy = NotInteiroValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotInteiro {
	
	String message() default "O parametro possui numero inteiro!";

	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {}; 
}
