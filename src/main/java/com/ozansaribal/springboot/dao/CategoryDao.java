package com.ozansaribal.springboot.dao;

import com.ozansaribal.springboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {

    List<Category> findAllByTopCategoryIsNullOrderByNameDesc();

    List<Category> findAllByNameEndsWith(String name);

}