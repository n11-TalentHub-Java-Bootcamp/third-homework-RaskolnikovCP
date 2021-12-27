package com.ozansaribal.springboot.transactional.ts10;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts10Service3 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void kategoriKaydet(int i) {

        Category category = new Category();
        category.setAdi("transactional10-" + i);
        category.setKirilim(1L);
        categoryEntityService.save(category);

        if (i == 9){
            throw new RuntimeException("hata");
        }
    }
}
