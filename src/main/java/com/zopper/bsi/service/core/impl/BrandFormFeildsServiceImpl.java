package com.zopper.bsi.service.core.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.zopper.bsi.models.BrandFormFeilds;
import com.zopper.bsi.dao.BrandFormFeildsDao;
import com.zopper.bsi.response.BrandFormFeildsResponse;
import com.zopper.bsi.service.core.BrandFormFeildsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudhir on 19/5/16.
 */
@Service
public class BrandFormFeildsServiceImpl implements BrandFormFeildsService {

    @Autowired
    BrandFormFeildsDao brandFormFeildsDao;

    @Override
    public List<BrandFormFeildsResponse> findByBrandId(Long brandId) {
        Iterable<BrandFormFeilds> brandFormFeildsList = brandFormFeildsDao.findByBrandId(brandId);
        List<BrandFormFeildsResponse> brandFormFeildsResponse = new ArrayList<>();
        mapToResponseObject(brandFormFeildsList, brandFormFeildsResponse);
        return brandFormFeildsResponse;
    }

    private void mapToResponseObject(Iterable<BrandFormFeilds> sourceObject, List<BrandFormFeildsResponse> targetInstance) {
        if (sourceObject == null)
            return;
        List<BrandFormFeildsResponse> brandFormFeildsResponse = new ArrayList<BrandFormFeildsResponse>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            targetInstance.addAll(objectMapper.readValue(new Gson().toJson(sourceObject), new TypeReference<List<BrandFormFeildsResponse>>() { }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BrandFormFeildsResponse> findAll() {
        Iterable<BrandFormFeilds> brandFormFeildsList = brandFormFeildsDao.findAll();
        List<BrandFormFeildsResponse> brandFormFeildsResponse = new ArrayList<>();
        mapToResponseObject(brandFormFeildsList, brandFormFeildsResponse);
        return brandFormFeildsResponse;}

    @Override
    public BrandFormFeilds findOne(Long id) {
        return brandFormFeildsDao.findOne(id);
    }

    @Override
    public Long save(BrandFormFeilds brandFormFeilds) throws Exception {
        brandFormFeilds.getBrandId();
        BrandFormFeilds brandFormFeildsDB = brandFormFeildsDao.findByBrandIdAndParamKey(brandFormFeilds.getBrandId(), brandFormFeilds.getParamKey());
        if (brandFormFeildsDB != null){
            throw new Exception();
        }
        brandFormFeildsDao.save(brandFormFeilds);
        return brandFormFeilds.getId();
    }
}
