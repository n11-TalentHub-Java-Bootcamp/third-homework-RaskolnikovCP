package com.ozansaribal.springboot.transactional.ts10;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class Ts10Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts10Service2 ts10Service2;

    public void save(){
        Category category = new Category();
        category.setAdi("transactional10-1");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        ts10Service2.topluKaydet();

        System.out.println("10-1");
    }
}
