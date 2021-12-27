package com.ozansaribal.springboot.transactional.ts13;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts13Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts13Service2 ts13Service2;

    public void save(){
        Category category = new Category();
        category.setAdi("transactional13-1");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        ts13Service2.save();

        System.out.println("13-1");
    }
}
