package com.zopper.bsi.dao;

import com.zopper.bsi.models.BrandFormFeilds;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by sudhir on 19/5/16.
 */
@Transactional
public interface BrandFormFeildsDao extends CrudRepository<BrandFormFeilds, Long> {
    public Iterable<BrandFormFeilds> findByBrandId(Long brandId);
    BrandFormFeilds findByBrandIdAndParamKey(Long brandId, String paramKey);
}
