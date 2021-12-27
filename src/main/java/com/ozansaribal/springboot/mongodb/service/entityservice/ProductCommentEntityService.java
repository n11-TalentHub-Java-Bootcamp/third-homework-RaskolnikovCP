package com.ozansaribal.springboot.mongodb.service.entityservice;

import com.ozansaribal.springboot.mongodb.entity.ProductComment;
import com.ozansaribal.springboot.mongodb.repository.ProductCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductCommentEntityService {

    @Autowired
    private ProductCommentRepository productCommentRepository;

    public List<ProductComment> findAll(){
        return productCommentRepository.findAll();
    }

    public ProductComment findById(String id){

        Optional<ProductComment> optional = productCommentRepository.findById(id);

        ProductComment productComment = null;
        if (optional.isPresent()){
            productComment = optional.get();
        }

        return productComment;
    }

    public ProductComment save(ProductComment productComment){
        return productCommentRepository.save(productComment);
    }

    public void deleteById(String id){
        productCommentRepository.deleteById(id);
    }

}
