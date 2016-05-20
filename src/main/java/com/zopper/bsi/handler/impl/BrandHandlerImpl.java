package com.zopper.bsi.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.zopper.bsi.enums.RequestType;
import com.zopper.bsi.handler.BrandHandler;
import com.zopper.bsi.request.BrandServiceRequest;
import com.zopper.bsi.response.BrandServiceResponse;
import com.zopper.bsi.service.brand.BrandRequestService;

/**
 * Created by sudhir on 20/5/16.
 */
@Component
public class BrandHandlerImpl implements BrandHandler {
	
	private @Autowired ApplicationContext applicationContext;
	private @Autowired Environment environment;
	
    @Override
    public void onboardItemForBrand(String orderId) {

    }

	@Override
	public BrandServiceResponse raiseRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception {
		BrandServiceResponse brandServiceResponse = null;
		if(RequestType.DEMO.equals(brandServiceRequest.getRequestType())) {
			brandServiceResponse = raiseDemoRequestForBrand(brandServiceRequest);
		} else if(RequestType.INSTALLATION.equals(brandServiceRequest.getRequestType())) {
			brandServiceResponse = raiseInstallationRequestForBrand(brandServiceRequest);
		} else if(RequestType.REPAIR.equals(brandServiceRequest.getRequestType())) {
			// TODO - implement later
		} else if(RequestType.REPLACE.equals(brandServiceRequest.getRequestType())) {
			// TODO - implement later
		}
		return brandServiceResponse;
	}

	@Override
	public BrandServiceResponse raiseDemoRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception {
		String beanName = environment.getProperty("brand_" + brandServiceRequest.getBrandId());
		System.out.println("beanName: " + beanName);
		BrandRequestService brandRequestService = (BrandRequestService) applicationContext.getBean(beanName);
		return brandRequestService.raiseDemoRequest(brandServiceRequest);
	}

	@Override
	public BrandServiceResponse raiseInstallationRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception {
		String beanName = environment.getProperty("brand_" + brandServiceRequest.getBrandId());
		System.out.println("beanName: " + beanName);
		BrandRequestService brandRequestService = (BrandRequestService) applicationContext.getBean(beanName);
		return brandRequestService.raiseInstallationRequest(brandServiceRequest);
	}

}
