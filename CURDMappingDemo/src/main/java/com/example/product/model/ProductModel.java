package com.example.product.model;

import com.example.product.entity.SKUEntity;

public class ProductModel {
    private String productId;
    private String productName;
    private String productCategory;
    private String productBrand;
    private SKUEntity skuEntity;

    public ProductModel(String productId, String productName, String productCategory, String productBrand, SKUEntity skuEntity) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.skuEntity = skuEntity;
    }

    public ProductModel() {}

    public SKUEntity getSkuEntity() {
        return skuEntity;
    }

    public void setSkuEntity(SKUEntity skuEntity) {
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

    @Override
    public String toString() {
        return "ProductModel{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", skuEntity=" + skuEntity +
                '}';
    }
}
