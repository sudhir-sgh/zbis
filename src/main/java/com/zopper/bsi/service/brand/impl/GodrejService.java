package com.zopper.bsi.service.brand.impl;

import org.springframework.stereotype.Service;

import com.zopper.bsi.request.BrandServiceRequest;
import com.zopper.bsi.response.BrandServiceResponse;
import com.zopper.bsi.service.brand.BrandRequestService;

/**
 * Created by sudhir on 20/5/16.
 */
@Service("godrejService")
public class GodrejService implements BrandRequestService {

    @Override
    public BrandServiceResponse raiseDemoRequest(BrandServiceRequest brandServiceRequest) throws Exception {
    	System.out.println("godrejService - demo");
        return null;
    }

    @Override
    public BrandServiceResponse raiseInstallationRequest(BrandServiceRequest brandServiceRequest) throws Exception {
    	System.out.println("godrejService - installation");
        return null;
    }
}
