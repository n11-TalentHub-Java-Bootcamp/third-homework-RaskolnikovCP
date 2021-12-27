package com.ozansaribal.springboot.transactional.ts8;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts8Service {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){
        Category category = new Category();
        category.setAdi("transaction8-1");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        save2();

        System.out.println("8-1");
    }

    /**
     * https://stackoverflow.com/questions/28480480/propagation-requires-new-does-not-create-a-new-transaction-in-spring-with-jpa
     *
     * Spring transactions are proxy-based. Here's thus how it works when bean A causes a transactional
     * of bean B. A has in fact a reference to a proxy, which delegates to the bean B.
     * This proxy is the one which starts and commits/rollbacks the transaction:
     *
     * A ---> proxy ---> B
     * In your code, a transactional method of A calls another transactional method of A.
     * So Spring can't intercept the call and start a new transaction.
     * It's a regular method call without any proxy involved.
     *
     * So, if you want a new transaction to start, the method createSampleObject() should be in another bean,
     * injected into your current bean.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save2(){
        Category category = new Category();
        category.setAdi("transaction8-2");
        category.setKirilim(1L);
        categoryEntityService.save(category);

        System.out.println("8-2");

    }
}
