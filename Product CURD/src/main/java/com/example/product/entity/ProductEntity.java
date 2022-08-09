package com.example.product.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class ProductEntity {
    @Id
    private String productId;
    @NotNull(message = "Name must required")
    private String productName;
    @NotNull(message = "Category must required")
    private String productCategory;
    @NotNull(message = "Brand must required")
    private String productBrand;

    @Embedded
    private SKUEntity skuEntity;
    public ProductEntity() {}

    public ProductEntity(String productId, String productName, String productCategory, String productBrand, SKUEntity skuEntity) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.skuEntity = skuEntity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    public SKUEntity getSkuEntity() {
        return skuEntity;
    }

    public void setSkuEntity(SKUEntity skuEntity) {
        this.skuEntity = skuEntity;
    }
}
