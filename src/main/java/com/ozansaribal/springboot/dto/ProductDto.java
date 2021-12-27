package com.ozansaribal.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@JsonFilter("UrunDtoFilter")
public class ProductDto {

    private Long id;

    @Size(min = 2)
    private String name;
    private BigDecimal price;

    @Past
    private Date register_date;
    private Long category_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getRegisterDate() {
        return register_date;
    }

    public void setRegisterDate(Date register_date) {
        this.register_date = register_date;
    }

    public Long getCategoryId() {
        return category_id;
    }

    public void setCategoryId(Long category_id) {
        this.category_id = category_id;
    }
}
