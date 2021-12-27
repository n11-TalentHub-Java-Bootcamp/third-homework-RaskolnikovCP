package com.ozansaribal.springboot.converter;

import com.ozansaribal.springboot.dto.CategoryDto;
import com.ozansaribal.springboot.entity.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mapping(target = "topCategoryId", source = "topCategory.id")
    CategoryDto convertCategoryToCategoryDto(Category category);

    @Mapping(target = "topCategoryId", source = "topCategory.id")
    List<CategoryDto> convertAllCategoryListToCategoryDtoList(List<Category> categoryList);

    @Mapping(target = "topCategory.id", source = "topCategoryId")
    Category convertCategoryDtoToCategory(CategoryDto categoryDto);

    @AfterMapping
    default void setNulls(@MappingTarget Category category, CategoryDto categoryDto){
        if (categoryDto.getTopCategoryId() == null){
            category.setTopCategory(null);
        }
    }
}
