package com.patika.cafestorewebapp.AOP.Annotations;

import com.patika.cafestorewebapp.AOP.Validators.CategoryNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CategoryNameValidator.class})
public @interface CategoryNameMustBeUnique {
    String message() default "Category name must be unique!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
