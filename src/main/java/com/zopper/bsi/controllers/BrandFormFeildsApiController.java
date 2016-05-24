package com.zopper.bsi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zopper.bsi.models.BrandFormFeilds;
import com.zopper.bsi.request.BrandFormFeildsRequest;
import com.zopper.bsi.response.APIResponse;
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
    public APIResponse findAll(){
        return new APIResponse(brandFormFeildsService.findAll());
    }

    @RequestMapping(value="/{brandId}",method = RequestMethod.GET,produces="application/json")
    @ResponseBody public APIResponse list(@PathVariable(value="brandId") Long brandId){
        return new APIResponse(brandFormFeildsService.findByBrandId(brandId));
    }

    @RequestMapping(value="/",method = RequestMethod.POST,produces="application/json")
    @ResponseBody public APIResponse addNew(@RequestBody @Valid BrandFormFeildsRequest brandFormFeildsRequest) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        BrandFormFeilds brandFormFeilds = objectMapper.readValue(AppUtils.toJson(brandFormFeildsRequest), BrandFormFeilds.class);
        return new APIResponse(brandFormFeildsService.save(brandFormFeilds));
    }

}
