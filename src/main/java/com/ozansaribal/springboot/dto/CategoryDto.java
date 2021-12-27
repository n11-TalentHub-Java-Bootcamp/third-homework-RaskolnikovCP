package com.ozansaribal.springboot.dto;

public class CategoryDto {

    private Long id;
    private String name;
    private Long refraction;
    private Long top_category_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRefraction() {
        return refraction;
    }

    public void setRefraction(Long refraction) {
        this.refraction = refraction;
    }

    public Long getTopCategoryId() {
        return top_category_id;
    }

    public void setTopCategoryId(Long top_category_id) {
        this.top_category_id = top_category_id;
    }
}
