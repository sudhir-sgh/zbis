package com.zopper.bsi.service.impl;

import com.zopper.bsi.models.BrandFormFeilds;
import com.zopper.bsi.dao.BrandFormFeildsDao;
import com.zopper.bsi.service.BrandFormFeildsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zopper on 19/5/16.
 */
@Service
public class BrandFormFeildsServiceImpl implements BrandFormFeildsService {

    @Autowired
    BrandFormFeildsDao brandFormFeildsDao;

    @Override
    public Iterable<BrandFormFeilds> findByBrandId(Long brandId) {
        return brandFormFeildsDao.findByBrandId(brandId);
    }

    @Override
    public Iterable<BrandFormFeilds> findAll() {
        return brandFormFeildsDao.findAll();
    }

    @Override
    public BrandFormFeilds findOne(Long id) {
        return brandFormFeildsDao.findOne(id);
    }

    @Override
    public BrandFormFeilds save(BrandFormFeilds brandFormFeilds) {
        return brandFormFeildsDao.save(brandFormFeilds);
    }
}
