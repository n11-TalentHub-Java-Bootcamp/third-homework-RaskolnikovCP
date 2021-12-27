package com.ozansaribal.springboot.transactional.ts15;

import com.ozansaribal.springboot.dao.CategoryDao;
import com.ozansaribal.springboot.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class Ts15EntityService {

    private Map<Long, Category> kategoriMap = new LinkedHashMap<>();

    @Autowired
    private CategoryDao categoryDao;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Category findById(Long id){

        Category category = kategoriMap.get(id);

        if (category != null){
            return category;
        }

        Optional<Category> optionalKategori = categoryDao.findById(id);

        if (optionalKategori.isPresent()){
            category = optionalKategori.get();
        }

        kategoriMap.put(id, category);

        return category;
    }

}