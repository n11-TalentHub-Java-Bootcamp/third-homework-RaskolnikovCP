package com.ozansaribal.springboot.transactional.ts6;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class Ts6Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){
        Category category = new Category();
        category.setAdi("transactional6-1");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        System.out.println("kayıt başarılı");

        throw new RuntimeException("hata");

    }
}
