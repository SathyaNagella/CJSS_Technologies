package com.example.springvalidator.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidatorClass implements ConstraintValidator<MyValid,String> {

    @Override
    public void initialize(MyValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.charAt(0)>='A'&&value.charAt(0)<='Z') return true;
        return false;
    }
}
