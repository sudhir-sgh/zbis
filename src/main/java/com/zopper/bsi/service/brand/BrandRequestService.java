package com.zopper.bsi.service.brand;

import com.zopper.bsi.request.BrandServiceRequest;
import com.zopper.bsi.response.BrandServiceResponse;

/**
 * Created by sudhir on 20/5/16.
 */
public interface BrandRequestService {
	
	public BrandServiceResponse raiseDemoRequest(BrandServiceRequest brandServiceRequest) throws Exception;
	
	public BrandServiceResponse raiseInstallationRequest(BrandServiceRequest brandServiceRequest) throws Exception;

}
