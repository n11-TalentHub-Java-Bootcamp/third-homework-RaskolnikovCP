package com.ozansaribal.springboot.transactional.ts12;

import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts12Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts12Service2 ts12Service2;

    public void save(){
        ts12Service2.save();
    }
}
