package com.example.product.entity;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Embeddable
public class SKUEntity implements Serializable {
    @NotEmpty(message = "Id must required")
    private String skuId;
    @NotEmpty(message = "Please enter any color")
    private String skuColour;
    @NotEmpty(message = "Please enter Size")
    private String skuSize;
    @NotNull(message = "Price must required")
    private Long skuPrice;
    @NotNull(message = "Stock need not be 0 or null")
    private Integer skuStock;


    public SKUEntity() {}

    public SKUEntity(String skuId, String skuColour, String skuSize, Long skuPrice, Integer skuStock) {
        this.skuId = skuId;
        this.skuColour = skuColour;
        this.skuSize = skuSize;
        this.skuPrice = skuPrice;
        this.skuStock = skuStock;
    }

    public String getSkuId() {return skuId;}

    public void setSkuId(String skuId) {this.skuId = skuId;}

    public String getSkuColour() {return skuColour;}

    public void setSkuColour(String skuColour) {this.skuColour = skuColour;}

    public String getSkuSize() {return skuSize;}

    public void setSkuSize(String skuSize) {this.skuSize = skuSize;}

    public Long getSkuPrice() {return skuPrice;}

    public void setSkuPrice(Long skuPrice) {this.skuPrice = skuPrice;}

    public Integer getSkuStock() {return skuStock;}

    public void setSkuStock(Integer skuStock) {this.skuStock = skuStock;}

    @Override
    public String toString() {
        return "SKUEntity{" +
                "skuId='" + skuId + '\'' +
                ", skuColour='" + skuColour + '\'' +
                ", skuSize='" + skuSize + '\'' +
                ", skuPrice=" + skuPrice +
                ", skuStock=" + skuStock +
                '}';
    }
}
