package com.example.product.validator;

import com.example.product.model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserModel userModel=(UserModel)target;
        //User ID
        if(userModel.getUserId().length()!=0){
            if(!userModel.getUserId().startsWith("U")){
                errors.rejectValue("userId","UserId");
            }
        } else {
            ValidationUtils.rejectIfEmpty(errors,"userId","UserIdEmpty");
        }

        //User Name
        String userName = userModel.getUserName();
        if (userName.length()!=0) {
            for (int i = 0; i < userName.length(); i++) {
                if (!((userName.charAt(i) >= 'A' && userName.charAt(i) <= 'Z') || (userName.charAt(i) >= 'a' && userName.charAt(i) <= 'z'))) {
                    errors.rejectValue("userName", "UserName");
                    break;
                }
            }
        }else{
            ValidationUtils.rejectIfEmpty(errors, "userName", "UserNameEmpty");
        }

        //User MobileNo
        if (userModel.getUserMobileNo().toString().length()!=0) {
            if (userModel.getUserMobileNo().toString().length() != 10) {
                errors.rejectValue("userMobileNo", "UserMobileNo");
            }
        }else {
            ValidationUtils.rejectIfEmpty(errors, "userMobileNo", "UserMobileNoEmpty");
        }

        //User Password
        if (userModel.getUserPassWord().length()!=0) {
            if (userModel.getUserPassWord().toString().length()<=3) {
                errors.rejectValue("userPassWord", "UserPassWord");
            }
        }else {
            ValidationUtils.rejectIfEmpty(errors, "userPassWord", "UserPassWordEmpty");
        }
    }
}
