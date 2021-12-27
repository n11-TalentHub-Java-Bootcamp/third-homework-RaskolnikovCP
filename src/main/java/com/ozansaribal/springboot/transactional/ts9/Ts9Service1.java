package com.ozansaribal.springboot.transactional.ts9;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class Ts9Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts9Service2 ts9Service2;

    public void save(){
        Category category = new Category();
        category.setAdi("transactional9-1");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        ts9Service2.save2();

        System.out.println("8-1");

    }
}
