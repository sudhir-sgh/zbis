package com.zopper.bsi.handler;

import com.zopper.bsi.request.BrandServiceRequest;
import com.zopper.bsi.response.BrandServiceResponse;

public interface BrandHandler {
	
	public void onboardItemForBrand(String orderId);
	
	public BrandServiceResponse raiseRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception;
	
	public BrandServiceResponse raiseDemoRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception;
	
	public BrandServiceResponse raiseInstallationRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception;

}
