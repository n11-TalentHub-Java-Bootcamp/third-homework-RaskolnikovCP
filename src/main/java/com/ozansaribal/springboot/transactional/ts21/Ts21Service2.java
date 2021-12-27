package com.ozansaribal.springboot.transactional.ts21;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts21Service2 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Transactional(propagation = Propagation.NEVER)
    public void save(){
        Category category = new Category();
        category.setAdi("transactional14-1");
        category.setKirilim(1L);
        categoryEntityService.save(category);
    }
}
