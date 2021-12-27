package com.ozansaribal.springboot.dto;

import java.math.BigDecimal;

public class ProductDetailsDto {

    private String product_name;
    private String category_name;
    private BigDecimal product_price;

    public ProductDetailsDto() {
    }

    public ProductDetailsDto(String product_name, String category_name, BigDecimal product_price) {
        this.product_name = product_name;
        this.category_name = category_name;
        this.product_price = product_price;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }

    public BigDecimal getProductPrice() {
        return product_price;
    }

    public void setProductPrice(BigDecimal product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "ProductDetailsDto{" +
                "product_name='" + product_name + '\'' +
                ", category_name='" + category_name + '\'' +
                ", product_price=" + product_price +
                '}';
    }
}
