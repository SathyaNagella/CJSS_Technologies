package com.example.product.validator;

import com.example.product.model.AdminModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class AdminValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AdminModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminModel adminModel = (AdminModel) target;
        //Admin Id
        if (adminModel.getAdminId() != null) {
            if (!adminModel.getAdminId().startsWith("A")) {
                errors.rejectValue("adminId", "AdminId");
            }
        } else {
            ValidationUtils.rejectIfEmpty(errors, "adminId", "AdminIdEmpty");
        }

        //Admin Name
        String adminName = adminModel.getAdminName();
        if (adminModel.getAdminName().length()!=0) {
            for (int i = 0; i < adminName.length(); i++) {
                if (!((adminName.charAt(i) >= 'A' && adminName.charAt(i) <= 'Z') || (adminName.charAt(i) >= 'a' && adminName.charAt(i) <= 'z'))) {
                    errors.rejectValue("adminName", "adminName");
                    break;
                }
            }
        }else{
            ValidationUtils.rejectIfEmpty(errors, "adminName", "AdminNameEmpty");
        }

        //Admin MobileNo
        if (adminModel.getAdminMobileNo() != null) {
            if (adminModel.getAdminMobileNo().toString().length() != 10) {
                errors.rejectValue("adminMobileNo", "mobileNo");
            }
        }else {
            ValidationUtils.rejectIfEmpty(errors, "adminMobileNo", "AdminMobileNoEmpty");
        }
    }
}
