package com.ozansaribal.springboot.mongodb.service;

import com.ozansaribal.springboot.mongodb.entity.ProductComment;
import com.ozansaribal.springboot.mongodb.service.entityservice.ProductCommentEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {

    @Autowired
    private ProductCommentEntityService productCommentEntityService;

    public List<ProductComment> findAll() {
        return productCommentEntityService.findAll();
    }

    public ProductComment findById(String id) {
        return productCommentEntityService.findById(id);
    }

    public ProductComment save(ProductComment productComment) { return productCommentEntityService.save(productComment); }

    public void delete(String id) {
        productCommentEntityService.deleteById(id);
    }

}
