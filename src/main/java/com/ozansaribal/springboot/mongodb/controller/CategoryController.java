package com.ozansaribal.springboot.mongodb.controller;

import com.ozansaribal.springboot.mongodb.converter.CategoryConverter;
import com.ozansaribal.springboot.mongodb.dto.CategoryDto;
import com.ozansaribal.springboot.mongodb.entity.Category;
import com.ozansaribal.springboot.mongodb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<CategoryDto> findAll() {

        List<Category> categoryList = categoryService.findAll();

        List<CategoryDto> categoryDtoList = CategoryConverter.INSTANCE.convertAllCategoryListToCategoryDtoList(categoryList);

        return categoryDtoList;

        //return categoryService.findAll();

    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CategoryDto categoryDto) {

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        category = categoryService.save(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        categoryService.delete(id);
    }

}
