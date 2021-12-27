package com.ozansaribal.springboot.mongodb.converter;

import com.ozansaribal.springboot.mongodb.dto.CategoryDto;
import com.ozansaribal.springboot.mongodb.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mapping(target = "topCategoryId", source = "superCategoryId")
    @Mapping(target = "refraction", source = "level")
    CategoryDto convertCategoryToCategoryDto(Category category);

    @Mapping(target = "topCategoryId", source = "superCategoryId")
    @Mapping(target = "refraction", source = "level")
    List<CategoryDto> convertAllCategoryListToCategoryDtoList(List<Category> categoryList);

//    @Mapping(target = "topCategory.id", source = "topCategoryId", expression = "java(null))
//    @Mapping(target = "topCategory.id", source = "topCategoryId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)

    //    @Mapping(target = "topCategory.id", expression = "java(categoryDto.getTopCategoryId() == null ? null : " +
//            "categoryDto.getTopCategoryId())")

    Category convertCategoryDtoToCategory(CategoryDto categoryDto);

}
