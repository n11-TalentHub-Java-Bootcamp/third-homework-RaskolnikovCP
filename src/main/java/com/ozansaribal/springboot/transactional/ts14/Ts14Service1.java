package com.ozansaribal.springboot.transactional.ts14;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ts14Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts14Service2 ts14Service2;

    public void save(){

        Category category = new Category();
        category.setAdi("transactional14-1");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        ts14Service2.save();

        System.out.println("14-1");
    }
}
