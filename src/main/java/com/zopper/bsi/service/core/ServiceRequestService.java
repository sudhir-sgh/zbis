package com.zopper.bsi.service.core;

import java.util.List;

import com.zopper.bsi.models.ServiceRequest;
import com.zopper.bsi.request.Criteria;

public interface ServiceRequestService {
	
	List<ServiceRequest> getAllServiceRequests(Criteria criteria) throws Exception;
	
	ServiceRequest getByReferenceNumber(String referenceNumber) throws Exception;

}
