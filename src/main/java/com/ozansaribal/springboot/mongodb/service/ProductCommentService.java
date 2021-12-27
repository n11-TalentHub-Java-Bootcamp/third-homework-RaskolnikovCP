package com.ozansaribal.springboot.mongodb.service;

import com.ozansaribal.springboot.mongodb.entity.ProductComment;

import java.util.List;

public interface ProductCommentService {

    List<ProductComment> findAll();

    ProductComment findById(String id);

    ProductComment save(ProductComment productComment);

    void delete(String id);

}
