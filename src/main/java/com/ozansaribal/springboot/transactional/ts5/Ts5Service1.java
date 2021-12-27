package com.ozansaribal.springboot.transactional.ts5;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class Ts5Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts5Service2 ts5Service2;

    public void save(){

        Category category = new Category();
        category.setAdi("transactional5-1");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        ts5Service2.save();

        System.out.println("5-1");
    }
}
