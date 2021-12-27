package com.ozansaribal.springboot.transactional.ts9;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class Ts9Service2 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save2(){
        Category category = new Category();
        category.setAdi("transaction9-2");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        System.out.println("9-2");

    }
}
