package com.example.product.validator;
import com.example.product.entity.SKUEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class SKUValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SKUEntity.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
       SKUEntity skuEntity= (SKUEntity) target;
       //skuID
       String data=skuEntity.getSkuId();
       int i=0,j=0;
       for (int ch=0;ch<data.length();ch++){
           if(data.charAt(ch)>=48&& data.charAt(ch)<=57)   i++;
           if((data.charAt(ch)>='a'&&data.charAt(ch)<='z')||(data.charAt(ch)>='A'&&data.charAt(ch)<='Z')) j++;
       }
       if(data.length()!=0){
        if(i==0||j==0)  errors.rejectValue("skuId","SkuId");}

        //SkuSize
        String skuSize=skuEntity.getSkuSize();
        if(skuSize.length()!=0){
            try{
                int var=Integer.parseInt(skuSize);
                if(var<0) errors.rejectValue("skuSize","SkuSize");
            }catch (NumberFormatException numberFormatException){
                if(skuSize.contains("-"))  errors.rejectValue("skuSize","SkuSize");
            }
        }

        //skuPrice
            if(skuEntity.getSkuPrice()!=null ) {
           if (skuEntity.getSkuPrice() < 0) {
                    errors.rejectValue("skuPrice", "skuPriceNegative");
                }
            }
        //skuStock
        if(skuEntity.getSkuStock()!=null){
                if(skuEntity.getSkuStock()<0){
                errors.rejectValue("skuStock","skuStockNegative");
            }
        }

    }
}