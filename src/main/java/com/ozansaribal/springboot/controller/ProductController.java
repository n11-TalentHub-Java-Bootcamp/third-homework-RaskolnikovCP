package com.ozansaribal.springboot.controller;

import com.ozansaribal.springboot.converter.ProductConverter;
import com.ozansaribal.springboot.dto.ProductDetailsDto;
import com.ozansaribal.springboot.dto.ProductDto;
import com.ozansaribal.springboot.entity.Product;
import com.ozansaribal.springboot.exception.ProductNotFoundException;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import com.ozansaribal.springboot.service.entityservice.ProductEntityService;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    private ProductEntityService productEntityService;
    
    @Autowired
    private CategoryEntityService categoryEntityService;

    @GetMapping("")
    public MappingJacksonValue findAllProductList() {

        List<Product> productList = productEntityService.findAll();

        String filterName = "ProductFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        MappingJacksonValue mapping = new MappingJacksonValue(productList);

        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findProductById(@PathVariable Long id){

        Product product = productEntityService.findById(id);

        if (product == null){
            throw new ProductNotFoundException("Urun not found. id: " + id);
        }

        WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllProductList()
        );

        ProductDto productDto = ProductConverter.INSTANCE.convertProductToProductDto(product);

        String filterName = "ProductDtoFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        EntityModel entityModel = EntityModel.of(productDto);

        entityModel.add(linkToProduct.withRel("all-products"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/detail/{id}")
    public ProductDetailsDto findProductDtoById(@PathVariable Long id){

        Product product = productEntityService.findById(id);

        if (product == null){
            throw new ProductNotFoundException("Product not found. id: " + id);
        }

        ProductDetailsDto productDetailsDto = ProductConverter.INSTANCE.convertProductToProductDetailsDto(product);

        return productDetailsDto;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveProduct(@Valid @RequestBody ProductDto productDto){

        Product product = ProductConverter.INSTANCE.convertProductDtoToProduct(productDto);

        product = productEntityService.save(product);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id){

        productEntityService.deleteById(id);
    }

    @GetMapping("categories/{categoryId}")
    public List<ProductDetailsDto> findAllProductByCategoryId(@PathVariable Long categoryId){

        List<Product> productList = productEntityService.findAllByCategoryOrderByIdDesc(categoryId);

        List<ProductDetailsDto> productDetailsDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailsDtoList(productList);

        return productDetailsDtoList;
    }

    private SimpleFilterProvider getProductFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getProductFilter();

        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private SimpleBeanPropertyFilter getProductFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "price", "register_date");
    }
}
