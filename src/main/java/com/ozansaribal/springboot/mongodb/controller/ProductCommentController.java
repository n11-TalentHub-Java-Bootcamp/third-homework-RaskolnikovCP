package com.ozansaribal.springboot.mongodb.controller;

import com.ozansaribal.springboot.mongodb.converter.MemberConverter;
import com.ozansaribal.springboot.mongodb.converter.ProductCommentConverter;
import com.ozansaribal.springboot.mongodb.dto.MemberDto;
import com.ozansaribal.springboot.mongodb.dto.ProductCommentDto;
import com.ozansaribal.springboot.mongodb.entity.Member;
import com.ozansaribal.springboot.mongodb.entity.ProductComment;
import com.ozansaribal.springboot.mongodb.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productComments/")
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping("")
    public List<ProductCommentDto> findAll() {

        List<ProductComment> productCommentList = productCommentService.findAll();

        List<ProductCommentDto> productCommentDtoList = ProductCommentConverter.INSTANCE.convertAllProductCommentListToProductCommentDtoList(productCommentList);

        return productCommentDtoList;

        //return productCommentService.findAll();

    }

    @GetMapping("/{id}")
    public ProductComment findById(@PathVariable String id) {
        return productCommentService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductCommentDto productCommentDto) {

        ProductComment productComment = ProductCommentConverter.INSTANCE.convertProductCommentDtoToProductComment(productCommentDto);

        productComment = productCommentService.save(productComment);

        return new ResponseEntity<>(productComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productCommentService.delete(id);
    }

}
