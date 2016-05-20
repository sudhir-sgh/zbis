package com.zopper.bsi.service.core;

import com.zopper.bsi.models.BrandFormFeilds;
import com.zopper.bsi.response.BrandFormFeildsResponse;

import java.util.List;

/**
 * Created by sudhir on 19/5/16.
 */
public interface BrandFormFeildsService {
    List<BrandFormFeildsResponse> findByBrandId(Long brandId);
    List<BrandFormFeildsResponse> findAll();
    BrandFormFeilds findOne(Long id);
    Long save(BrandFormFeilds brandFormFeilds) throws Exception;
}
