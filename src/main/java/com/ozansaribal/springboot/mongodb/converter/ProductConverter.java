package com.ozansaribal.springboot.mongodb.converter;

import com.ozansaribal.springboot.mongodb.dto.ProductDetailDto;
import com.ozansaribal.springboot.mongodb.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(target = "productName", source = "name")
    @Mapping(target = "productPrice", source = "price")
    ProductDetailDto convertProductToProductDetailDto(Product product);

    @Mapping(target = "productName", source = "name")
    @Mapping(target = "productPrice", source = "price")
    List<ProductDetailDto> convertAllProductListToProductDetailDtoList(List<Product> product);

//    @AfterMapping
//    default void setCategoryName(@MappingTarget final ProductDetailDto productDetailDto,
//                                 Product product){
//        if (product.getCategoryId() == null){
//            product.setCategory(null);
//        }
//    }
}
