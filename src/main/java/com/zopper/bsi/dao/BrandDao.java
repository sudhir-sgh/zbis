package com.zopper.bsi.dao;

import com.zopper.bsi.models.Brand;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by sudhir on 19/5/16.
 */
@Transactional
public interface BrandDao extends CrudRepository<Brand, Long> {
    public Brand findByBrandKey(String brandKey);
}
