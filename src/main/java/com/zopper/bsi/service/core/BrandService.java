package com.zopper.bsi.service.core;

import com.zopper.bsi.models.Brand;

/**
 * Created by sudhir on 19/5/16.
 */
public interface BrandService {
    Brand findByKey(String key);
    Brand findOne(Long id);
    Iterable<Brand> findAll();

}
