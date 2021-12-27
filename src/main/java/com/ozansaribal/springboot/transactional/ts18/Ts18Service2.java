package com.ozansaribal.springboot.transactional.ts18;

import com.ozansaribal.springboot.entity.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class Ts18Service2 {

    public Category getKategori(){
        return null;
    }
}
