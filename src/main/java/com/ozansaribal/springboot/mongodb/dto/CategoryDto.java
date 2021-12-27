package com.ozansaribal.springboot.mongodb.dto;

public class CategoryDto {

    public CategoryDto(String id, String name, Long refraction, String topCategoryId) {
        this.id = id;
        this.name = name;
        this.refraction = refraction;
        this.topCategoryId = topCategoryId;
    }

    public CategoryDto() {
    }

    private String id;
    private String name;
    private Long refraction;
    private String topCategoryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getTopCategoryId() {
        return topCategoryId;
    }

    public void setTopCategoryId(String topCategoryId) {
        this.topCategoryId = topCategoryId;
    }

}
