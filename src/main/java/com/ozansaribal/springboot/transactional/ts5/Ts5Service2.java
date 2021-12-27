package com.ozansaribal.springboot.transactional.ts5;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class Ts5Service2 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){

        Category category = new Category();
        category.setAdi("transactional5-2");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        System.out.println("5-2");

    }
}
