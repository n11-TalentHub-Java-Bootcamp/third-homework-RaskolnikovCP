package com.ozansaribal.springboot.transactional.ts17;

import com.ozansaribal.springboot.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class Ts17Service1 {

    @Autowired
    private Ts17Service2 ts17Service2;

    public void test(){

        Date date1 = new Date();
        System.out.println("başladı");

        for (int i = 0; i< 9999; i++){
            Category category = ts17Service2.getKategori();
        }

        System.out.println("bitti");
        Date date2 = new Date();

        long diff = date2.getTime() - date1.getTime();

        System.out.println(diff);
    }
}
