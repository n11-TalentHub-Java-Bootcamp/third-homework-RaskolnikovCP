package com.ozansaribal.springboot.mongodb.repository;

import com.ozansaribal.springboot.mongodb.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
