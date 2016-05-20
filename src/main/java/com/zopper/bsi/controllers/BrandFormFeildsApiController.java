package com.zopper.bsi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zopper.bsi.models.BrandFormFeilds;
import com.zopper.bsi.request.BrandFormFeildsRequest;
import com.zopper.bsi.response.BrandFormFeildsResponse;
import com.zopper.bsi.service.core.BrandFormFeildsService;
import com.zopper.bsi.utils.AppUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sudhir on 19/5/16.
 */
@RestController
@RequestMapping("/brand-request-form")
public class BrandFormFeildsApiController {

    Logger logger  = Logger.getLogger(BrandFormFeildsApiController.class);

    @Autowired
    private BrandFormFeildsService brandFormFeildsService;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<BrandFormFeildsResponse>> findAll(){
        return new ResponseEntity<List<BrandFormFeildsResponse>>(brandFormFeildsService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/{brandId}",method = RequestMethod.GET,produces="application/json")
    @ResponseBody public ResponseEntity<List<BrandFormFeildsResponse>> list(@PathVariable(value="brandId") Long brandId){
        return new ResponseEntity<List<BrandFormFeildsResponse>>(brandFormFeildsService.findByBrandId(brandId), HttpStatus.OK);
    }

    @RequestMapping(value="/",method = RequestMethod.POST,produces="application/json")
    @ResponseBody public ResponseEntity<Long> addNew(@RequestBody @Valid BrandFormFeildsRequest brandFormFeildsRequest) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        BrandFormFeilds brandFormFeilds = objectMapper.readValue(AppUtils.toJson(brandFormFeildsRequest), BrandFormFeilds.class);
        return new ResponseEntity<Long>(brandFormFeildsService.save(brandFormFeilds), HttpStatus.OK);
    }

}
