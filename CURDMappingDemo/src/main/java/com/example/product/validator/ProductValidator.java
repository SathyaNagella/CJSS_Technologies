package com.example.product.validator;

import com.example.product.entity.ProductEntity;
import com.example.product.model.ProductModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
//        productId;
//        productName;
//        productCategory;
//        productBrand;
@Component
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProductModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductModel productModel= (ProductModel) target;
        //ID
        if(productModel.getProductId().length()!=0){
            if(!productModel.getProductId().startsWith("P"))
                errors.rejectValue("productId","ProductIdStarts","Id must Start with P ");
        }else  errors.rejectValue("productId","ProductId","Id must required");

        //name
        if(productModel.getProductName().length()!=0){

        }else  errors.rejectValue("productName","ProductName","Name must required");
        //Category
        if(productModel.getProductCategory().length()!=0){

        }else  errors.rejectValue("productCategory","ProductCategory","Category must required");
        //Brand
        if(productModel.getProductBrand().length()!=0){

        }else  errors.rejectValue("productBrand","ProductBrand","Brand must required");
    }
}
