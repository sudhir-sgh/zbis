package com.zopper.bsi.controllers;

import com.zopper.bsi.models.Brand;
import com.zopper.bsi.dao.BrandDao;
import com.zopper.bsi.service.BrandService;
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
    public ResponseEntity<Brand> sendEmail(@PathVariable(value="key") String key){
        Brand brand = brandService.findByKey(key);
        return new ResponseEntity<Brand>(brand, HttpStatus.OK);
    }

    @RequestMapping(value="/list",method = RequestMethod.GET,produces="application/json")
    @ResponseBody public ResponseEntity<Iterable<Brand>> list(){
        return new ResponseEntity<Iterable<Brand>>(brandService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/",method = RequestMethod.POST,produces="application/json")
    @ResponseBody public ResponseEntity<Brand> addNew(@RequestBody Brand brand){
        return new ResponseEntity<Brand>(brandDao.save(brand), HttpStatus.OK);
    }

}
