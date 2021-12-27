package com.ozansaribal.springboot.transactional.ts4;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ts4Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts4Service2 ts4Service2;

    public void save(){
        Category category = new Category();
        category.setAdi("transactional4-1");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        ts4Service2.save();

        System.out.println("4-1");
    }
}
