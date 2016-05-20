package com.zopper.bsi.service.core;

import com.zopper.bsi.models.ServiceRequest;

public interface ServiceRequestService {
	
	Iterable<ServiceRequest> getAllServiceRequests() throws Exception;
	
	ServiceRequest getByReferenceNumber(String referenceNumber) throws Exception;

}
