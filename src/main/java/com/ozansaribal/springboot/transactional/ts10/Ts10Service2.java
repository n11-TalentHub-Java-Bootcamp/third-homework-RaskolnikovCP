package com.ozansaribal.springboot.transactional.ts10;

import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts10Service2 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts10Service3 ts10Service3;

    public void topluKaydet(){

        for (int i = 2; i < 12; i++){
            try {
                ts10Service3.kategoriKaydet(i);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
