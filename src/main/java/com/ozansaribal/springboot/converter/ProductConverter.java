package com.ozansaribal.springboot.converter;

import com.ozansaribal.springboot.dto.ProductDetailsDto;
import com.ozansaribal.springboot.dto.ProductDto;
import com.ozansaribal.springboot.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(source = "categoryId", target = "category.id")
    Product convertProductDtoToProduct(ProductDto productDto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto convertProductToProductDto(Product product);

    @Mapping(source = "price", target = "product_price")
    @Mapping(source = "name", target = "product_name")
    @Mapping(source = "category.name", target = "category_name")
    ProductDetailsDto convertProductToProductDetailsDto(Product product);

    @Mapping(source = "price", target = "product_price")
    @Mapping(source = "name", target = "product_name")
    @Mapping(source = "category.name", target = "category_name")
    List<ProductDetailsDto> convertAllProductListToProductDetailsDtoList(List<Product> productList);

    @AfterMapping
    default void setNulls(@MappingTarget final Product product, ProductDto productDto){
        if (productDto.getCategoryId() == null){
            product.setCategory(null);
        }
    }
}
