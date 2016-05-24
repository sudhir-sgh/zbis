package com.zopper.bsi.service.brand.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zopper.bsi.dao.BrandIfbDao;
import com.zopper.bsi.dao.ServiceRequestDao;
import com.zopper.bsi.models.BrandIfb;
import com.zopper.bsi.models.ServiceOnboardSummary;
import com.zopper.bsi.models.ServiceRequest;
import com.zopper.bsi.request.BrandServiceRequest;
import com.zopper.bsi.response.BrandServiceResponse;
import com.zopper.bsi.service.brand.BrandRequestService;
import com.zopper.bsi.service.core.ServiceOnboardSummaryService;

/**
 * Created by sudhir on 20/5/16.
 */
@Service("ifbService")
public class IfbService implements BrandRequestService {
	
	private @Autowired ServiceOnboardSummaryService serviceOnboardSummaryService;
	private @Autowired BrandIfbDao brandIfbDao;
	private @Autowired ServiceRequestDao serviceRequestDao;

    @Override
    public BrandServiceResponse raiseDemoRequest(BrandServiceRequest brandServiceRequest) throws Exception {
    	System.out.println("IfbService - demo");
    	BrandServiceResponse brandServiceResponse = doCommonTask(brandServiceRequest);
        return brandServiceResponse;
    }

    @Override
    public BrandServiceResponse raiseInstallationRequest(BrandServiceRequest brandServiceRequest) throws Exception {
    	System.out.println("IfbService - installation");
    	BrandServiceResponse brandServiceResponse = doCommonTask(brandServiceRequest);
        return brandServiceResponse;
    }
    
    private BrandServiceResponse doCommonTask(BrandServiceRequest brandServiceRequest) throws Exception {
    	ServiceOnboardSummary serviceOnboardSummary = serviceOnboardSummaryService.getByOrderId(brandServiceRequest.getOrderId());
    	
    	BrandIfb brandIfb = new BrandIfb();
    	brandIfb.setAlternatePhoneNumber(brandServiceRequest.getAlternatePhoneNumber());
    	brandIfbDao.save(brandIfb);
    	
    	ServiceRequest serviceRequest = new ServiceRequest();
    	serviceRequest.setRequestType(brandServiceRequest.getRequestType());
    	serviceRequest.setRequestSource(brandServiceRequest.getRequestSource());
    	serviceRequest.setBrandId(brandServiceRequest.getBrandId());
    	serviceRequest.setReferenceNumber(brandServiceRequest.getReferenceNumber());
    	serviceRequest.setServiceOnboardSummary(serviceOnboardSummary);
    	serviceRequest.setSpecificBrandId(brandIfb.getId());
    	serviceRequestDao.save(serviceRequest);
    	
    	BrandServiceResponse brandServiceResponse = new BrandServiceResponse();
    	brandServiceResponse.setOrderId(brandServiceRequest.getOrderId());
    	brandServiceResponse.setReferenceNumber(serviceRequest.getReferenceNumber());
        return brandServiceResponse;
    }
}
