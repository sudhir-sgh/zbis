package com.zopper.bsi.service.core.impl;

import com.zopper.bsi.models.Brand;
import com.zopper.bsi.dao.BrandDao;
import com.zopper.bsi.service.core.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sudhir on 19/5/16.
 */
@Component
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandDao brandDao;

    @Override
    public Brand findByKey(String key) {
        return brandDao.findByBrandKey(key);
    }

    @Override
    public Brand findOne(Long id) {
        return brandDao.findOne(id);
    }

    @Override
    public Iterable<Brand> findAll() {
        return brandDao.findAll();
    }
}
