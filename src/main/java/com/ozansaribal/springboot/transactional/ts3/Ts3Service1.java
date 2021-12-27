package com.ozansaribal.springboot.transactional.ts3;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts3Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts3Service2 ts3Service2;

    public void save(){

        Category category = new Category();
        category.setAdi("transactional3-1");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        ts3Service2.save();

        System.out.println("transactional service ends");

    }
}
