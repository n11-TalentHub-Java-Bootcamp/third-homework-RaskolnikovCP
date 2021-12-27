package com.ozansaribal.springboot.transactional.ts3;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ts3Service2 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){

        Category category = new Category();
        category.setAdi("transactional3-2");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        System.out.println("non transactional service ends");

    }
}
