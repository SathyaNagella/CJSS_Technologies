package com.example.springvalidator.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy=MyValidatorClass.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface  MyValid {
    String message() default "{City name must start with Capital letter}";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
