package com.ozansaribal.springboot.controller;

import com.ozansaribal.springboot.converter.CategoryConverter;
import com.ozansaribal.springboot.converter.ProductConverter;
import com.ozansaribal.springboot.dto.CategoryDto;
import com.ozansaribal.springboot.dto.ProductDetailsDto;
import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.entity.Product;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import com.ozansaribal.springboot.service.entityservice.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private ProductEntityService productEntityService;

    @GetMapping("")
    public List<CategoryDto> findAll(){

        List<Category> categoryList = categoryEntityService.findAll();

        List<CategoryDto> categoryDtoList = CategoryConverter.INSTANCE.convertAllCategoryListToCategoryDtoList(categoryList);

        return categoryDtoList;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){

        Category category = categoryEntityService.findById(id);

        return category;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CategoryDto categoryDto){

        // input value must be in Dto type

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        category = categoryEntityService.save(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("")
    public CategoryDto update(@RequestBody CategoryDto categoryDto){

        // input value must be in Dto type

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        // we need to apply checking

        if (category.getTopCategory() != null && category.getTopCategory().getId() == null){
            category.setTopCategory(null);
        }

        category = categoryEntityService.save(category);

        CategoryDto categoryDtoResult = CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);

        return categoryDtoResult;
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        categoryEntityService.deleteById(id);
    }

    // localhost:8080/api/categories/{id}/products

    @GetMapping("/{id}/products")
    public List<ProductDetailsDto> findAllProductByCategoryId(@PathVariable Long id){
        List<Product> productList = productEntityService.findAllByCategoryOrderByIdDesc(id);

        List<ProductDetailsDto> productDetailsDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailsDtoList(productList);

        return productDetailsDtoList;
    }
}
