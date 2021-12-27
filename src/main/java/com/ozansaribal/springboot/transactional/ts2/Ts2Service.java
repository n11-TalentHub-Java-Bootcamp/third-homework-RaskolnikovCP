package com.ozansaribal.springboot.transactional.ts2;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts2Service {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){

        Category category = new Category();
        category.setAdi("transactional2");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        System.out.println("end");
    }

    public void test(){
        System.out.println("");
    }
}
