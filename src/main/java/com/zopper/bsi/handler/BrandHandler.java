package com.zopper.bsi.handler;

import java.util.concurrent.Future;

import com.zopper.bsi.request.BrandServiceRequest;
import com.zopper.bsi.response.BrandServiceResponse;

public interface BrandHandler {
	
	public Future<BrandServiceResponse> raiseRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception;
	
	public BrandServiceResponse raiseDemoRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception;
	
	public BrandServiceResponse raiseInstallationRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception;

	Future<Long> onboardItemForBrand(Long orderId) throws Exception;

}
