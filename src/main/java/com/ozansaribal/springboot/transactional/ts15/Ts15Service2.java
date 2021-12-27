package com.ozansaribal.springboot.transactional.ts15;

import com.ozansaribal.springboot.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class Ts15Service2 {

    @Autowired
    private Ts15EntityService ts15EntityService;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void findAll() {
        for (int i = 0; i< 9999; i++){
            Category category = ts15EntityService.findById(1L);
        }
    }
}
