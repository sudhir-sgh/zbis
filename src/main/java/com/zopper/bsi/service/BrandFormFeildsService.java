package com.zopper.bsi.service;

import com.zopper.bsi.models.Brand;
import com.zopper.bsi.models.BrandFormFeilds;

/**
 * Created by sudhir on 19/5/16.
 */
public interface BrandFormFeildsService {
    Iterable<BrandFormFeilds> findByBrandId(Long brandId);
    Iterable<BrandFormFeilds> findAll();
    BrandFormFeilds findOne(Long id);
    BrandFormFeilds save(BrandFormFeilds brandFormFeilds);
}
