package com.ozansaribal.springboot.transactional.ts13;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts13Service2 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void save(){

        Category category = new Category();
        category.setAdi("transactional13-2");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        System.out.println("13-2");
    }
}
