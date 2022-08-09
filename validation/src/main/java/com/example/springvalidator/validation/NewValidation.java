package com.example.springvalidator.validation;

import com.example.springvalidator.model.CustomerModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class NewValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"cusFirstName","FirstName");
        CustomerModel cus=(CustomerModel) target;
        if(cus.getCusMobileNo()!=null) {
            if (cus.getCusMobileNo().toString().length() != 10) {
                errors.rejectValue("cusMobileNo", "mobile.No");
            }
            }else {
                ValidationUtils.rejectIfEmpty(errors,"cusMobileNo","cusMobileNo.empty");
        }
    }
}
