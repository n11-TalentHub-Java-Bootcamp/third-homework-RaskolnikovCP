package com.ozansaribal.springboot.mongodb.converter;

import com.ozansaribal.springboot.mongodb.dto.ProductCommentDto;
import com.ozansaribal.springboot.mongodb.entity.ProductComment;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface ProductCommentConverter {

    ProductCommentConverter INSTANCE = Mappers.getMapper(ProductCommentConverter.class);

    @Mapping(source = "id", target = "comment_id")
    @Mapping(source = "comment", target = "comment_dto")
    @Mapping(source = "comment_date", target = "comment_date_dto")
    @Mapping(source = "product_id", target = "product_id_dto")
    @Mapping(source = "member_id", target = "member_id_dto")
    List<ProductCommentDto> convertAllProductCommentListToProductCommentDtoList(List<ProductComment> productCommentList);

    @Mapping(source = "comment_id", target = "id")
    @Mapping(source = "comment_dto", target = "comment")
    @Mapping(source = "comment_date_dto", target = "comment_date")
    @Mapping(source = "product_id_dto", target = "product_id")
    @Mapping(source = "member_id_dto", target = "member_id")
    ProductComment convertProductCommentDtoToProductComment (ProductCommentDto productCommentDto);

}
