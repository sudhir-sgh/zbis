package com.zopper.bsi.controllers;

import com.zopper.bsi.models.Brand;
import com.zopper.bsi.dao.BrandDao;
import com.zopper.bsi.response.APIResponse;
import com.zopper.bsi.service.core.BrandService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sudhir on 19/5/16.
 */
@RestController
@RequestMapping("/brand")
public class BrandApiController {

    Logger logger  = Logger.getLogger(BrandApiController.class);

    @Autowired
    private BrandService brandService;
    @Autowired
    BrandDao brandDao;

    @RequestMapping(value="/{key}",method = RequestMethod.GET)
    @ResponseBody
    public APIResponse findByBrandKey(@PathVariable(value="key") String key){
        Brand brand = brandService.findByKey(key);
        return new APIResponse(brand);
    }

    @RequestMapping(value="/list",method = RequestMethod.GET,produces="application/json")
    @ResponseBody public APIResponse list(){
        return new APIResponse(brandService.findAll());
    }

    @RequestMapping(value="/",method = RequestMethod.POST,produces="application/json")
    @ResponseBody public APIResponse addNew(@RequestBody Brand brand){
        return new APIResponse(brandDao.save(brand));
    }

}
